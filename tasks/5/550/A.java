/**
 * @problem http://codeforces.com/problemset/problem/550/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
	
	String s;

	void in() {
		s = in.nextLine();
	}

	boolean matches(char a, char b) {
		int i1 = s.indexOf(a + "" + b);
		int i2 = s.lastIndexOf(b + "" + a);

		//outln("i1 = " + i1 + "\t" + "i2 = " + i2);

		return i1 >= 0 && i2 >= 0 && i1 + 1 < i2;
	}

	boolean solve() {
		return matches('A', 'B') || matches('B', 'A');
	}

	void main() {
		in();
		out(solve() ? "YES" : "NO");
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new A().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}