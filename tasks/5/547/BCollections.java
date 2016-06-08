/**
 * @problem http://codeforces.com/problemset/problem/547/B
 * @status OK
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BCollections {

	int n;
	List<Integer> a;

	void in() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.valueOf(in.readLine());

			String[] s = in.readLine().split(" ");

			a = new ArrayList<>(n);

			for (String sa : s) {
				a.add(Integer.valueOf(sa));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	void out(List<Integer> res) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

			for (int a : res) {
				out.print(a + " ");
			}
			out.println();

		}
	}

	List<Integer> getFirstLower(List<Integer> a) {
		List<Integer> m = new ArrayList<>(n);
		for (int i = 0; i < n; ++ i) {
			m.add(-1);
		}

		for (int i = n - 2; i >= 0; -- i) {
			int curr = a.get(i);
			int mi = -1;

			for (int j = i + 1; j != -1; j = m.get(j)) {
				int next = a.get(j);
				if (curr > next) {
					mi = j;
					break;
				} else if (curr == next) {
					mi = m.get(j);
					break;
				}
			}

			m.set(i, mi);
		}

		return m;
	}

	void makeRightRadius(List<Integer> m) {
		for (int i = 0; i < n; ++ i) {
			int mi = m.get(i);
			m.set(i, mi != -1 ? mi - i : n - i);
		}
	}

	List<Integer> makeDiametrs(List<Integer> rl, List<Integer> rr) {
		List<Integer> d = new ArrayList<>(n);
		for (int i = 0; i < n; ++ i) {
			d.add(rl.get(i) + rr.get(i) - 1);
		}
		return d;
	}

	List<Integer> makeLine(List<Integer> a, List<Integer> d) {
		List<Integer> line = new ArrayList<>(n);
		for (int i = 0; i <= n; ++ i) {
			line.add(-1);
		}
		for (int i = 0; i < n; ++ i) {
			int di = d.get(i);
			int li = line.get(di);
			line.set(di, Math.max(li, a.get(i)));
		}
		return line;
	}

	List<Integer> makeRes(List<Integer> line) {
		List<Integer> res = new ArrayList<>(n);
		int curr = -1;
		for (int i = n; i >= 1; -- i) {
			int a = line.get(i);
			if (a != -1) {
				curr = Math.max(a, curr);
			}
			res.add(curr);
		}
		Collections.reverse(res);
		return res;
	}

	List<Integer> solve() {
		List<Integer> rr = getFirstLower(a);
		makeRightRadius(rr);

		Collections.reverse(a);
		List<Integer> rl = getFirstLower(a);
		makeRightRadius(rl);
		Collections.reverse(rl);
		Collections.reverse(a);

		List<Integer> d = makeDiametrs(rl, rr);

		List<Integer> line = makeLine(a, d);
		
		List<Integer> res = makeRes(line);
		return res;
	}

	void main() {
		in();
		List<Integer> res = solve();
		out(res);
	}

    public static void main(String[] args) { new BCollections().main(); }

}