/**
 * @problem http://www.codeforces.com/problemset/problem/522/B
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B {
    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int n = in.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];
		int W;
		int H1, H2, iH1;

		W = 0;
		iH1 = 0;
		for (int i = 0; i < n; ++ i) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();

			W += a[i];
			if (b[i] > b[iH1]) {
				iH1 = i;
			}
		}

		H1 = b[iH1];
		H2 = - 1;
		for (int i = 0; i < n; ++ i) {
			if (i != iH1) {
				H2 = Math.max(H2, b[i]);
			}
		}

		for (int i = 0; i < n; ++ i) {
			long wi = W - a[i];
			long hi = (i != iH1 ? H1 : H2);
			long bi = wi * hi;
			out(bi);
			out(" ");
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString()); }
}