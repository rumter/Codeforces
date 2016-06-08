/**
 * @problem http://codeforces.com/problemset/problem/493/C
 * @status PROCESS
 */
import java.io.*;
import java.util.*;
public class C {
    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++ i) {
			a[i] = in.nextInt();
		}

		int m = in.nextInt();
		int b[] = new int[m];
		for (int i = 0; i < m; ++ i) {
			b[i] = in.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int t[] = new int[1 + n + m];
		t[0] = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n || j < m) {
			if (i < n && j < m) {
				if (a[i] <= b[j]) {
					if (t[k] != a[i]) {
						t[++ k] = a[i];
					}
					++ i;
				} else if (a[i] > b[j]) {
					if (t[k] != b[j]) {
						t[++ k] = b[j];
					}
					++ j;
				}
			}
			else {
				if (i < n) {
					if (t[k] != a[i]) {
						t[++ k] = a[i];
					}
					++ i;
				}
				if (j < m) {
					if (t[k] != b[j]) {
						t[++ k] = b[j];
					}
					++ j;
				}
			}
		}
		++ k;

		for (int i = 0; i < k; ++ i) {
			int d = t[i];

			int i1 = Arrays.binarySearch(a, d);
			int i2 = Arrays.binarySearch(b, d);

			if (i1 < 0) {
				i1 = (- i1 - 1);
			}
			int n1 = i1;

			if (i2 < 0) {
				i2 = (- i2 - 1);
			}
			int m1 = i2;

			int s1 = 3 * n - n1;
			int s2 = 3 * m - m1;
		}


    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}