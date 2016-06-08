/**
 * @problem http://codeforces.com/problemset/problem/515/C
 * @status OK
 */
import java.io.*;
import java.util.*;
public class C {
    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final int N = 10;

		int c2[] = new int[N];
		int c3[] = new int[N];
		int c5[] = new int[N];
		int c7[] = new int[N];
		Arrays.fill(c2, 0);
		Arrays.fill(c3, 0);
		Arrays.fill(c5, 0);
		Arrays.fill(c7, 0);
		// 2 = 2
		++ c2[2];
		// 3 = 3
		++ c3[3];
		// 4 = 2*2
		++ c2[4]; ++ c2[4];
		// 5 = 5
		++ c5[5];
		// 6 = 2*3
		++ c2[6];
		++ c3[6];
		// 7 = 7
		++ c7[7];
		// 8 = 2*2*2
		++ c2[8]; ++ c2[8]; ++ c2[8];
		// 9 = 3*3
		++ c3[9]; ++ c3[9];

		int cf2[] = new int[N];
		int cf3[] = new int[N];
		int cf5[] = new int[N];
		int cf7[] = new int[N];
		Arrays.fill(cf2, 0);
		Arrays.fill(cf3, 0);
		Arrays.fill(cf5, 0);
		Arrays.fill(cf7, 0);
		for (int i = 2; i <= 9; ++ i) {
			cf2[i] = cf2[i - 1] + c2[i];
			cf3[i] = cf3[i - 1] + c3[i];
			cf5[i] = cf5[i - 1] + c5[i];
			cf7[i] = cf7[i - 1] + c7[i];
			//out(cf2[i] + "" + cf3[i] + "" + cf5[i] + "" + cf7[i] + "\n");
		}

		int n = in.nextInt();
		String s = in.next();

		int ca2 = 0;
		int ca3 = 0;
		int ca5 = 0;
		int ca7 = 0;
		for (int i = 0; i < s.length(); ++ i) {
			int c = (int) (s.charAt(i) - '0');
			ca2 += cf2[c];
			ca3 += cf3[c];
			ca5 += cf5[c];
			ca7 += cf7[c];
		}
		//log(ca2 + " " + ca3 + " " + ca5 + " " + ca7);

		while(ca7 > 0) {
			int c = 7;
			out(c);
			ca2 -= cf2[c];ca3 -= cf3[c];ca5 -= cf5[c];ca7 -= cf7[c];
		}
		while(ca5 > 0) {
			int c = 5;
			out(c);
			ca2 -= cf2[c];ca3 -= cf3[c];ca5 -= cf5[c];ca7 -= cf7[c];
		}
		while(ca3 > 0) {
			int c = 3;
			out(c);
			ca2 -= cf2[c];ca3 -= cf3[c];ca5 -= cf5[c];ca7 -= cf7[c];
		}
		while(ca2 > 0) {
			int c = 2;
			out(c);
			ca2 -= cf2[c];ca3 -= cf3[c];ca5 -= cf5[c];ca7 -= cf7[c];
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.print(s.toString()); }
}