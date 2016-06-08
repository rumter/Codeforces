/**
 * @problem http://codeforces.com/problemset/problem/524/C
 * @status OK
 */
import java.io.*;
import java.util.*;
public class C {

	final int A = 10*1000*1000 + 1000;

	Scanner in;

	int n, k;
	int a[];
	boolean isA[];

	void in() {
		in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n];
		isA = new boolean[A];
		Arrays.fill(isA, false);
		for (int i = 0; i < n; ++ i) {
			a[i] = in.nextInt();
			isA[a[i]] = true;
		}
	}

	int req(int x) {
		for (int sk = 1; sk <= k; ++ sk) {
			for (int i = n - 1; i >= 0; -- i) {
				if (sk * a[i] < x) {
					continue;
				}

				if (sk * a[i] == x) {
					return sk;
				}	

				for (int k1 = 0; k1 < sk; ++ k1) {
					int k2 = sk - k1;

					int m = x - (a[i] * k1);

					if (m == 0) {
						return sk;
					}

					if (m < 0) {
						break;
					}

					if (m % k2 == 0) {
						int a2 = m / k2;
						if (isA[a2]) {
							return sk;
						}
					}
				}
			}
		}
		return -1;
	}

	void req() {
		int q = in.nextInt();
		for (int i = 0; i < q; ++ i) {
			int x = in.nextInt();
			int cnt = req(x);
			outln(cnt);
		}
	}

	void solve() {
		in();
		req();
	}

    public static void main(String[] args) throws IOException { new C().solve(); }
    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString()); }
    static void outln(Object s) { System.out.println(s.toString()); }
}