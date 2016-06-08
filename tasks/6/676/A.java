/**
 * @problem http://codeforces.com/problemset/problem/676/A
 * @status OK
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class A {

	int n;
	int i1, i2;

	void in() {
		n = in.nextInt();
		for (int i = 0; i < n; ++ i) {
			int a = in.nextInt();
			if (a == 1) {
				i1 = i;
			}
			if (a == n) {
				i2 = i;
			}
		}
	}

	void solve() {
		int res = IntStream.of(
			Math.abs(i2 - i1),
			Math.abs(n - 1 - i1),
			Math.abs(n - 1 - i2),
			i1,
			i2
		).max().getAsInt();
		outln(res);
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