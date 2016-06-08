/**
 * @problem http://codeforces.com/problemset/problem/550/C
 * @status OK
 * @about O(n^3)
 */
import java.io.*;
import java.util.*;

public class C {

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
		for (int k = n - 1; k >= 0; -- k) {
			for (int j = k - 1; j >= -1; -- j) {
				for (int i = j - 1; i >= -2; -- i) {

					int num = digit(k);
					if (j >= 0) {
						num += 10 * digit(j);
						if (i >= 0) {
							num += 100 * digit(i);
						}
					}
					//outln(String.format("%d,%d,%d = %d", i, j, k, num));

					if (num % 8 == 0) {
						return num;
					}
				}
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
    public static void main(String[] args) { new C().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}