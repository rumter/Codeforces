/**
 * @problem http://codeforces.com/problemset/problem/524/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {

	int m, k;
	int a[];
	int b[];
	int n;
	Map<Integer, Integer> getNum;
	Map<Integer, Integer> getId;
	boolean F[][];
	boolean F2[][];

	void in() {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		k = in.nextInt();
		a = new int[m];
		b = new int[m];
		for (int i = 0; i < m; ++ i) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
	}

	void buildNums() {
		Set<Integer> nums = new TreeSet<Integer>();
		for (int i = 0; i < m; ++ i) {
			nums.add(a[i]);
			nums.add(b[i]);
		}
		n = nums.size();
		getNum = new TreeMap<Integer, Integer>();
		getId = new TreeMap<Integer, Integer>();;
		int i = 0;
		for (Integer x : nums) {
			getNum.put(x, i);
			getId.put(i, x);
			++ i;
		}
	}

	void buildF() {
		F = new boolean[n][n];
		for (int i = 0; i < n; ++ i) for (int j = 0; j < n; ++ j) F[i][j] = false;
		for (int i = 0; i < m; ++ i) {
			int x = getNum.get(a[i]);
			int y = getNum.get(b[i]);
			F[x][y] = true;
			F[y][x] = true;
		}
	}

	void buildF2() {
		F2 = new boolean[n][n];
		for (int i = 0; i < n; ++ i) for (int j = 0; j < n; ++ j) F2[i][j] = false;
		for (int i = 0; i < n; ++ i) {
			int fx = 0;
			for (int j = 0; j < n; ++ j) {
				if (F[i][j] && i != j) {
					++ fx;
				}
			}

			final int C = (int) Math.ceil((double)(fx * k) / (double)100);

			for (int j = 0; j < n; ++ j) {
				if (i != j) {
					int c = 0;
					for (int u = 0; u < n; ++ u) {
						if (F[i][u] && F[u][j] && (i != u && u != j)) {
							++ c;
						}
					}
					F2[i][j] = (c >= C);
				}
			}
		}
	}

	void out() {
		for (int i = 0; i < n; ++ i) {
			int id = getId.get(i);
			int c = 0;
			for (int j = 0; j < n; ++ j) {
				if (F2[i][j] && !F[i][j]) {
					++ c;
				}
			}
			out(id + ": " + c + " ");
			for (int j = 0; j < n; ++ j) {
				if (F2[i][j] && !F[i][j]) {
					int id2 = getId.get(j);
					out(id2 + " ");
				}
			}
			outln("");
		}
	}

	void solve() {
		in();
		buildNums();
		buildF();
		buildF2();
		out();
	}

    public static void main(String[] args) throws IOException { new A().solve(); }
    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString()); }
    static void outln(Object s) { System.out.println(s.toString()); }
}