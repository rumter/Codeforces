/**
 * @problem http://codeforces.com/problemset/problem/549/A
 * @status OK
 */
import java.util.Scanner

object A {

	def detectFace(c1:Char, c2:Char, c3:Char, c4:Char):Boolean = 
		List(c1, c2, c3, c4).sorted.mkString.equals("acef")

	def countFaces(s1:String, s2:String):Int = {
		return (0 until s1.length() - 1)
			.map(i => detectFace(s1.charAt(i), s1.charAt(i + 1), s2.charAt(i), s2.charAt(i + 1)))
			.map(b => if (b) 1 else 0)
			.reduceLeft(_+_)
	}

	def readAndCountFaces(n:Int):Int = {
		var count:Int = 0
		var s1:String = in.nextLine
		for (i <- 2 to n) {
			var s2:String = in.nextLine
			count += countFaces(s1, s2)
			s1 = s2
		}
		count
	}

	val in:Scanner = new Scanner(System.in)

	def main(args: Array[String]) = {
		val n:Int = in.nextInt
		val m:Int = in.nextInt
		in.nextLine

		val count:Int = if (n > 1 && m > 1) readAndCountFaces(n) else 0

		println(count)
	}

}