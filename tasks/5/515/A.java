/**
 * @problem http://codeforces.com/problemset/problem/515/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int a = in.nextInt();
		int b = in.nextInt();
		int s = in.nextInt();

		int s0 = Math.abs(a) + Math.abs(b);
		if (s >= s0 && ((s - s0) % 2 == 0)) {
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