/**
 * @problem http://codeforces.com/problemset/problem/547/B
 * @status OK
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BArrays {

	int n;
	int a[];

	int[] rl, rr, d;

	int[] line, res;

	void in() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.valueOf(in.readLine());

			String[] s = in.readLine().split(" ");

			a = new int[n];
			for (int i = 0; i < n; ++ i) {
				a[i] = Integer.valueOf(s[i]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	void out() {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

			for (int a : res) {
				out.print(a + " ");
			}
			out.println();

		}
	}

	void makeFirstLower(int m[]) {
		Arrays.fill(m, -1);

		for (int i = n - 2; i >= 0; -- i) {
			int curr = a[i];

			for (int j = i + 1; j != -1; j = m[j]) {
				int next = a[j];

				if (curr > next) {
					m[i] = j;
					break;
				} else if (curr == next) {
					m[i] = m[j];
					break;
				}
			}
		}
	}

	void makeRightRadius(int[] m) {
		for (int i = 0; i < n; ++ i) {
			m[i] = (m[i] != -1 ? m[i] - i : n - i);
		}
	}

	void makeDiametrs() {
		for (int i = 0; i < n; ++ i) {
			d[i] = rl[i] + rr[i] - 1;
		}
	}

	void makeLine() {
		Arrays.fill(line, -1);
		for (int i = 0; i < n; ++ i) {
			line[d[i]] = Math.max(line[d[i]], a[i]);
		}
	}

	void makeAndOutRes() {
		res = new int[n];
		int curr = -1;
		for (int i = n; i >= 1; -- i) {
			curr = Math.max(line[i], curr);
			res[i - 1] = curr;
		}
	}

	void reverse(int a[]) {
		for (int i = 0; i < n / 2; ++ i) {
			int j = n - i - 1;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	void solve() {
		rr = new int[n];
		makeFirstLower(rr);
		makeRightRadius(rr);

		reverse(a);
		rl = new int[n];
		makeFirstLower(rl);
		makeRightRadius(rl);
		reverse(rl);
		reverse(a);

		d = new int[n];
		makeDiametrs();

		line = new int[n + 1];
		makeLine();
		
		makeAndOutRes();
	}

	void main() {
		in();
		solve();
		out();
	}

    public static void main(String[] args) { new BArrays().main(); }
}