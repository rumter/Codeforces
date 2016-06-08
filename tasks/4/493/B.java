/**
 * @problem http://codeforces.com/problemset/problem/493/B
 * @status WA
 */
import java.io.*;
import java.util.*;
public class B {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		final int N = 1000 * 1000;

		int a[] = new int[N];
		int b[] = new int[N];
		int na = 0;
		int nb = 0;
		int sum1 = 0;
		int sum2 = 0;
		int last = 0;

		int n = toi(in.readLine());

		for (int i = 0; i < n; ++ i) {
			int x = toi(in.readLine());
			if (x > 0) {
				a[na ++] = x;
				sum1 += x;
				last = 1;
			} else {
				b[nb ++] = - x;
				sum2 += - x;
				last = 2;
			}
		}

		if (sum1 > sum2) {
			out("first");
		} else if (sum1 < sum2) {
			out("second");
		} else {
			boolean isRes = false;
			for (int i = 0; !isRes && i < na && i < nb; ++ i) {
				if (a[i] > b[i]) {
					out("first");
					isRes = true;
					break;
				} else if (a[i] < b[i]) {
					out("second");
					isRes = true;
					break;
				}
			}

			if (!isRes) {
				if (na > nb) {
					out("first");
				} else if (na < nb) {
					out("second");
				} else {
					if (last == 1) {
						out("first");
					} else {
						out("second");
					}
				}
			}
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}