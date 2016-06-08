/**
 * @problem http://codeforces.com/problemset/problem/490/B
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		final int N = (int)1e6 + 1000;

		final int m = 2;
		final int left = 0;
		final int right = 1;


		int n = toi(in.readLine());

		int c[][] = new int[n][m];
		int l[] = new int[N];
		int r[] = new int[N];

		for (int i = 0; i < N; ++ i) {
			l[i] = - 1;
			r[i] = - 1;
		}

		int index1 = - 1;
		int index2 = - 1;

		for (int i = 0; i < n; ++ i) {
			String arr[] = in.readLine().split(" ");
			int a = toi(arr[0]);
			int b = toi(arr[1]);

			c[i][left] = a;
			c[i][right] = b;
			if (a != 0) {
				l[a] = i;
			}
			if (b != 0) {
				r[b] = i;
			}

			if (a == 0) {
				index1 = i;
			}
		}


		for (int i = 0; i < n; ++ i) {
			if (c[i][left] != 0 && r[c[i][left]] == - 1) {
				index2 = i;
			}
		}

		int buf2 = - 1;

		while(index1 != - 1 || index2 != - 1 || buf2 != - 1) {
			if (index2 != - 1) {
				out(c[index2][left]);
				int newIndex2 = l[c[index2][right]];
				if (newIndex2 == -1 && c[index2][right] != 0) {
					buf2 = c[index2][right];
				}
				index2 = newIndex2;
			} else if (buf2 > 0) {
				out(buf2);
				buf2 = - 1;
			}

			if (index1 != - 1) {
				out(c[index1][right]);
				index1 = l[c[index1][right]];

				if (index1 != -1 && c[index1][right] == 0) {
					index1 = - 1;
				}
			}
		}

		out("\n");
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString() + " "); }
}