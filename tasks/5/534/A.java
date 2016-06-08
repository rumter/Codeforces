/**
 * @problem http://codeforces.com/problemset/problem/534/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
	
	int n;

	void in() {
		n = in.nextInt();
	}

	// 2 4 1 3
	void commonSolution() {
		outln(n);
		for (int i = 2; i <= n; i += 2) {
			out(i + " ");
		}
		for (int i = 1; i <= n; i += 2) {
			out(i + " ");
		}
	}

	void partSolution() {
		if (n == 3) {
			outln("2");
			outln("1 3");
		} else {
			outln("1");
			outln("1");
		}
	}

	void solve() {
		if (n >= 4) {
			commonSolution();
		} else {
			partSolution();
		}
	}

	void main() {
		in();
		solve();
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new A().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}