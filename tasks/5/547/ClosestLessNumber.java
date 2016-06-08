/**
 * @task Задан массив чисел. Необходимо для каждого элемента массива найти другой ближайший справа элемент, значение которого будет меньше. Требование к сложности: O(nlogn).
 * @status 
 */
import java.io.*;
import java.util.*;

public class ClosestLessNumber {

	int n;
	int a[];

	int m[];
	int m2[];

	void in() {
		n = in.nextInt();
		a = new int[n];
		for (int i = 0; i < n; ++ i) {
			a[i] = in.nextInt();
		}
	}

	void solve() {
		// init

		m = new int[n];
		Arrays.fill(m, -1);

		// calc

		for (int i = n - 2; i >= 0; -- i) {
			if (a[i] > a[i + 1]) {
				m[i] = i + 1;
			}
			if (a[i] == a[i + 1]) {
				m[i] = m[i + 1];
			}
			if (a[i] < a[i + 1]) {
				for (int j = m[i + 1]; j != - 1; j = m[j]) {
					if (a[i] > a[j]) {
						m[i] = j;
						break;
					}
					if (a[i] == a[j]) {
						m[i] = m[j];
						break;
					}
				}
			}
		}

		// out

		// for (int i = 0; i < n; ++ i) {
		// 	out(m[i] + " ");
		// }
		// outln("");
	}

	void solveN2() {
		m2 = new int[n];
		Arrays.fill(m2, -1);

		for (int i = 0; i < n; ++ i) {
			int ans = -1;
			for (int j = i + 1; j < n; ++ j) {
				if (a[i] > a[j]) {
					ans = j;
					break;
				}
			}
			m2[i] = ans;
		}
	}

	boolean check() {
		for (int i = 0; i < n; ++ i) {
			if (m[i] != m2[i]) {
				return false;
			}
		}
		return true;
	}

	int time() { return (int)System.currentTimeMillis(); }

	Random r = new Random();
	int rand(int a, int b) { return r.nextInt(b - a - 1) + a; }

	void inN(int n) {
		this.n = n;
		outln(n);
		a = new int[n];
		for (int i = 0; i < n; ++ i) {
			a[i] = i + 1;
			//a[i] = rand(1, n);
			//out(a[i] + " ");
		}
		//outln("");
	}

	void main() {
		//in();
		inN(1000*10);
		{
			int t0 = time();
			solve();
			outln(String.format("time N = %d", time() - t0));
		}
		{
			int t0 = time();
			solveN2();
			outln(String.format("time N2 = %d", time() - t0));
		}
		outln(check());
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new ClosestLessNumber().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}