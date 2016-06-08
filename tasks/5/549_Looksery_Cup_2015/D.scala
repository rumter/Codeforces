/**
 * @problem http://codeforces.com/problemset/problem/549/D
 * @status OK
 */
import java.util.Scanner

object D {

	var n:Int = _
	var m:Int = _
	var w:Array[Array[Int]] = _

	def read() = {
		n = in.nextInt
		m = in.nextInt
		in.nextLine

		w = (0 until n).map(i => in.nextLine().toCharArray().map(c => if (c == 'W') 1 else -1).toArray).toArray
	}

	val in:Scanner = new Scanner(System.in)

	def main(args: Array[String]) = {
		read()

		val targetValue:Int = w(n - 1)(m - 1)

		var add:Array[Int] = Array.fill(m)(0)

		var count:Int = 0

		for (i <- n - 1 to 0 by -1) {
			for (j <- m - 1 to 0 by -1) {
				var value = w(i)(j) + add(j)
				if (value != targetValue) {
					for (k <- 0 to j) {
						add(k) += targetValue - value
					}
					count += 1
				}
			}
		}

		println(count + 1)
	}

}