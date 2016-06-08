/**
 * @problem http://codeforces.com/problemset/problem/515/B
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B {

	static boolean is[];
	static List<List<Integer>> e;

	static int gcd (int a, int b) {
  		if (a == 0) return b;
  		return gcd(b % a, a);
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	static void buildGraph(int n, int m) {
		int N = lcm(n, m);
		e = new ArrayList<List<Integer>>(n + m);
		for (int i = 0; i < n + m; ++ i) {
			e.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N; ++ i) {
			int x = i % n;
			int y = (i % m) + n;

			e.get(x).add(y);
			e.get(y).add(x);
		}
	}

	static void dfs(int v) {
		if (is[v]) return;
		is[v] = true;

		List<Integer> uList = e.get(v);
		for (int i = 0; i < uList.size(); ++ i) {
			int u = uList.get(i);
			if (!is[u]) {
				dfs(u);
			}
		}
	}

    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int n = in.nextInt();
		int m = in.nextInt();

		buildGraph(n, m);

		is = new boolean[n + m];
		Arrays.fill(is, false);

		int b = in.nextInt();
		for (int i = 0; i < b; ++ i) {
			int x = in.nextInt();
			if (!is[x]) {
				dfs(x);
			}
		}
		int g = in.nextInt();
		for (int i = 0; i < g; ++ i) {
			int y = in.nextInt() + n;
			if (!is[y]) {
				dfs(y);
			}
		}

		boolean res = true;
		for (int i = 0; i < n + m; ++ i) {
			res = res && is[i];
		}

		if (res) {
			out("Yes");
		} else {
			out("No");
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}