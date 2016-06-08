/**
 * @problem http://codeforces.com/problemset/problem/548/B
 * @status OK
 */
import java.util.Scanner

object B {

	var n:Int = _
	var m:Int = _
	var q:Int = _
	var b:Array[Array[Int]] = _
	var cnt:Array[Int] = _

	def read() = {
		n = in.nextInt
		m = in.nextInt
		q = in.nextInt
		in.nextLine

		b = (0 until n)
			.map(i => in.nextLine().split(" ").map(c => c.toInt))
			.toArray
	}

	def calcCnt(i:Int):Int = b(i)
		.scanLeft(0)((c:Int, v:Int) => (c + 1) * v)
		.reduceLeft(math.max)

	def prepareBeforeRounds() = {
		cnt = (0 until n).map(calcCnt(_)).toArray
	}

	def solveRound() = {
		val i = in.nextInt() - 1
		val j = in.nextInt() - 1

		b(i)(j) = 1 - b(i)(j)
		cnt(i) = calcCnt(i)

		println(cnt.reduceLeft(math.max))
	}

	val in:Scanner = new Scanner(System.in)

	def main(args: Array[String]) = {
		read()

		prepareBeforeRounds()

		for (i <- 1 to q) {
			solveRound()
		}
	}

}