/**
 * @problem http://codeforces.com/problemset/problem/490/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = toi(in.readLine());
		String arr[] = in.readLine().split(" ");

		int a[][] = new int[3 + 1][n];
		int na[] = new int[]{0,0,0,0};

		for (int i = 0; i < n; ++ i) {
			int x = toi(arr[i]);
			a[x][na[x]++] = i + 1;
		}

		int w = n;
		for (int i = 1; i <= 3; ++ i) {
			w = Math.min(w, na[i]);
		}

		out(w);
		for (int i = 0; i < w; ++ i) {
			out(a[1][i] + " " + a[2][i] + " " + a[3][i]);
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}