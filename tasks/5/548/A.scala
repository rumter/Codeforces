/**
 * @problem http://codeforces.com/problemset/problem/548/A
 * @status OK
 */
import scala.io.StdIn._

object A {

	def isPalindromSubstring(s:String, pos:Int, length:Int):Boolean = {
		for {
			i <- 0 until length / 2
			c1 = s.charAt(pos + i)
			c2 = s.charAt(pos + length - 1 - i)
		} {
			if (c1 != c2) 
				return false
		}
		return true
	}

	def isContainsKPalindroms(s:String, k:Int):Boolean = {
		if (s.length() % k == 0) {
			val length = s.length() / k;
			for (pos <- 0 until s.length() by length) {
				if (!isPalindromSubstring(s, pos, length)) {
					return false
				}
			}
			return true
		} else {
			return false
		}
	}

	def main(args:Array[String]) {
		println(if (isContainsKPalindroms(readLine, readInt)) "YES" else "NO")
	}
	
}


