/**
 * @problem http://codeforces.com/problemset/problem/513/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int k1 = in.nextInt();
		int k2 = in.nextInt();

		if (n1 > n2) {
			out("First");
		} else {
			out("Second");
		}		
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}