/**
 * @problem http://codeforces.com/problemset/problem/551/B
 * @status OK
 */
import java.io.*;
import java.util.*;

public class B {

	final int N = 26;

	String a, b, c;
	int w[], u[], v[];

	int n, m;

	void in() {
		a = in.nextLine();
		b = in.nextLine();
		c = in.nextLine();
	}

	int[] buildCountChars(String s) {
		int n[] = new int[N];
		Arrays.fill(n, 0);
		for (char c : s.toCharArray()) {
			n[c - 'a'] ++;
		}
		return n;
	}

	void buildWUV() {
		w = buildCountChars(a);
		u = buildCountChars(b);
		v = buildCountChars(c);
	}

	void searchNM() {
		n = 0;
		m = 0;
		for (int i = 0; i <= a.length() / b.length(); ++ i) {
			// w[k] - i*u[k] - j*v[k] >= 0

			boolean checkI = true;
			for (int k = 0; k < N; ++ k) {
				if (w[k] < i * u[k]) {
					checkI = false;
					break;
				}
			}
			if (!checkI) {
				continue;
			}

			// j <= (w[k] - i*u[k]) / v[k]

			int j = a.length() / c.length();
			for (int k = 0; k < N; ++ k) {
				if (v[k] == 0) {
					continue;
				}
				j = Math.min(j, (w[k] - i * u[k]) / v[k]);
			}

			// save max (n + m)

			if (i + j > n + m) {
				n = i;
				m = j;
			}
		}
	}

	void out() {
		int k = 0;
		for (int i = 0; i < n; ++ i) {
			out(b);
		}
		for (int i = 0; i < m; ++ i) {
			out(c);
		}
		for (int i = 0; i < N; ++ i) {
			int wi = w[i] - n * u[i] - m * v[i];
			char ch = (char)('a' + i);
			for (int j = 0; j < wi; ++ j) {
				out(ch);
			}
		}
	}

	void main() {
		in();
		
		buildWUV();

		searchNM();

		out();
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new B().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }

}