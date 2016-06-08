/**
 * @problem http://codeforces.com/problemset/problem/490/C
 * @status OK
 */
import java.io.*;
import java.util.*;
public class C {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String c = in.readLine();
		String arr[] = in.readLine().split(" ");
		long a = tol(arr[0]);
		long b = tol(arr[1]);

		int n = c.length();

		long a10 = 10L % a;
		long b10 = 10L % b;

		long y1[] = new long[n];
		long y2[] = new long[n];
		long p10[] = new long[n];

		y1[0] = (c.charAt(0) - '0') % a;
		for (int i = 1; i < n; ++ i) {
			long ca = (c.charAt(i) - '0') % a;
			y1[i] = ((y1[i - 1] * a10) % a + ca) % a;
		}

		p10[0] = 1L % b;
		for (int i = 1; i < n; ++ i) {
			p10[i] = (p10[i - 1] * b10) % b;
		}
		y2[n - 1] = (c.charAt(n - 1) - '0') % b;
		for (int i = n - 2; i >= 0; -- i) {
			long cb = (c.charAt(i) - '0') % b;
			y2[i] = (y2[i + 1] + (cb * p10[n - 1 - i]) % b) % b;
		}


		int index = - 1;
		for (int i = 0; i < n - 1; ++ i) {
			if (y1[i] == 0 && y2[i + 1] == 0 && c.charAt(i + 1) != '0') {
				index = i;
			}
		}


		if (index != - 1) {
			out("YES");
			out(c.substring(0, index + 1));
			out(c.substring(index + 1, n));
		} else {
			out("NO");
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}