/**
 * @problem http://codeforces.com/problemset/problem/524/B
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B {

	final int inf = 1000 * 1000 * 1000 + 1000;

	int n;
	int w[];
	int h[];
	
	void in() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		w = new int[n];
		h = new int[n];
		for (int i = 0; i < n; ++ i) {
			w[i] = in.nextInt();
			h[i] = in.nextInt();
		}
	}

	int minW(int H) {
		int W = 0;
		for (int i = 0; i < n; ++ i) {
			int a = w[i];
			int b = h[i];

			if (a <= H && b <= H) {
				W += Math.min(a, b);
			}

			if (a > H && b <= H) {
				W += a;
			}

			if (a <= H && b > H) {
				W += b;
			}

			if (a > H && b > H) {
				return inf;
			}
		}
		return W;
	}

	int minSquare() {
		int minS = inf;
		for (int i = 0; i < n; ++ i) {
			int H1 = h[i];
			int H2 = w[i];
			int W1 = minW(H1);
			int W2 = minW(H2);

			if (W1 < inf) {
				minS = Math.min(minS, W1 * H1);
			}
			if (W2 < inf) {
				minS = Math.min(minS, W2 * H2);
			}
		}
		return minS;
	}
	
	void ans() {
		int res = minSquare();
		outln(res);
	}

	void solve() {
		in();
		ans();
	}

    public static void main(String[] args) throws IOException { new B().solve(); }
    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString()); }
    static void outln(Object s) { System.out.println(s.toString()); }
}