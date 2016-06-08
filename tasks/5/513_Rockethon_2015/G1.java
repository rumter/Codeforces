/**
 * @problem http://codeforces.com/problemset/problem/513/G1
 * @status OK
 */
import java.io.*;
import java.util.*;
public class G1 {

	static class Permutation {
		public Integer p[];
		public Permutation(Integer _p[]) {
			p = Arrays.copyOf(_p, _p.length);
		}
		public boolean equals(Object obj) {
			return hashCode() == ((Permutation)obj).hashCode();
		}
		public int hashCode() {
			return Arrays.deepHashCode(p);
		}
		public void swap(int i, int j) {
			int tmp = p[j]; p[j] = p[i]; p[i] = tmp;
		}
		public int countInverse() {
			int cnt = 0;
			for (int i = 0; i < p.length; ++ i) {
				for (int j = i + 1; j < p.length; ++ j) {
					cnt += (p[j] < p[i] ? 1 : 0);
				}
			}
			return cnt;
		}
		public String toString() {
			return Arrays.toString(p) + " " + hashCode();
		}
	}

    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int n = in.nextInt();
		int k = in.nextInt();
		Integer p[] = new Integer[n];
		for (int i = 0; i < n; ++ i) {
			p[i] = in.nextInt();
		}

		HashMap<Permutation, Double> set1, set2;

		final double P = (double) 2 / ((double) n * (double) (n + 1));

		set1 = new HashMap<Permutation, Double>();
		set1.put(new Permutation(p), 1.0);

		for (int u = 0; u < k; ++ u) {
			set2 = new HashMap<Permutation, Double>();

			for (Map.Entry<Permutation, Double> perm : set1.entrySet()) {
				for (int i = 0; i < n; ++ i) {
					for (int j = i; j < n; ++ j) {
						Permutation permNew = new Permutation(perm.getKey().p);

						for (int v = 0; v < (j - i + 1) / 2; ++ v) {
							permNew.swap(i + v, j - v);
						}

						double permP = perm.getValue() * P;

						if (set2.containsKey(permNew)) {
							permP += set2.get(permNew);
						}
						set2.put(permNew, permP);
					}
				}
			}

			set1 = set2;
		}

		double m = 0;
		for (Map.Entry<Permutation, Double> perm : set1.entrySet()) {
			double cnt = (double) perm.getKey().countInverse();
			double pp = (double) perm.getValue();
			m += cnt * pp;
		}

		out(String.format("%.12f", m));
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}