/**
 * @problem http://codeforces.com/problemset/problem/550/B
 * @status OK
 */
import java.io.*;
import java.util.*;

public class B {

	static final int INF = (int)1e9;

	int n, l, r, x;
	int c[];

	int count = 0;

	void in() {
		n = in.nextInt();
		l = in.nextInt();
		r = in.nextInt();
		x = in.nextInt();
		c = new int[n];
		for (int i = 0; i < n; ++ i) {
			c[i] = in.nextInt();
		}
	}

	boolean bit(int p, int i) {
		return ((p >> i) & 1) == 1;
	}

	void solve() {
		for (int p = 1; p < (1 << n); ++ p) {
			int min = INF;
			int max = 0;
			int sum = 0;
			for (int i = 0; i < n; ++ i) {
				if (bit(p, i)) {
					min = Math.min(min, c[i]);
					max = Math.max(max, c[i]);
					sum += c[i];
				}
			}
			if (l <= sum && sum <= r && max - min >= x) {
				++ count;
			}
		}
	}

	void main() {
		in();
		solve();
		out(count);
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new B().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}