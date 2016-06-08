/**
 * @problem http://codeforces.com/problemset/problem/550/C
 * @status OK
 * @about O(n)
 */
import java.io.*;
import java.util.*;

public class C2 {

	String s;
	int n;

	void in() {
		s = in.nextLine();
		n = s.length();
	}

	int digit(int i) {
		return s.charAt(i) - '0';
	}

	int solve() {
		int r1[][] = new int[n][8];
		for (int i = 0; i < n; ++ i) {
			Arrays.fill(r1[i], -1);
		}

		for (int i = n - 1; i >= 0; -- i) {
			int d = digit(i);
			if (i < n - 1) {
				for (int j = 0; j < 8; ++ j) {
					r1[i][j] = r1[i + 1][j];
				}
			}
			r1[i][d % 8] = d;
			if (r1[i][0] != -1) {
				return r1[i][0];
			}
		}

		int r2[][] = new int[n][8];
		for (int i = 0; i < n; ++ i) {
			Arrays.fill(r2[i], -1);
		}
		for (int i = n - 2; i >= 0; -- i) {
			int d = digit(i);

			for (int j = 0; j < 8; ++ j) {
				r2[i][j] = r2[i + 1][j];
			}

			for (int j = 0; j < 8; ++ j) {
				if (r1[i + 1][j] != -1) {
					int k = (j + d * 10) % 8;
					r2[i][k] = r1[i + 1][j] + d * 10; 
				}
			}

			if (r2[i][0] != -1) {
				return r2[i][0];
			}
		}

		int r3[][] = new int[n][8];
		for (int i = 0; i < n; ++ i) {
			Arrays.fill(r3[i], -1);
		}
		for (int i = n - 3; i >= 0; -- i) {
			int d = digit(i);

			for (int j = 0; j < 8; ++ j) {
				r3[i][j] = r3[i + 1][j];
			}

			for (int j = 0; j < 8; ++ j) {
				if (r2[i + 1][j] != -1) {
					int k = (j + d * 100) % 8;
					r3[i][k] = r2[i + 1][j] + d * 100; 
				}
			}

			if (r3[i][0] != -1) {
				return r3[i][0];
			}
		}

		
		return -1;
	}

	void main() {
		in();
		int num = solve();
		if (num >= 0) {
			outln("YES");
			outln(num);
		} else {
			outln("NO");
		}
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new C2().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}