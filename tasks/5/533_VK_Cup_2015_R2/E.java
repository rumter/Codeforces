/**
 * @problem http://codeforces.com/problemset/problem/533/E
 * @status PROCESS
 */
import java.io.*;
import java.util.*;
public class E {

	Scanner in;

	int n;
	String s, t;
	
	void in() {
		in = new Scanner(System.in);
		n = in.nextInt();
		s = in.next();
		t = in.next();
	}

	int check1() {
		int i;
		int a, b, c;

		a = 0;
		for (i = 0; i < n; ++ i) {
			if (s.charAt(i) != t.charAt(i)) {
				break;
			}
		}
		a = i;

		c = 0;
		for (i = n - 1; i >= 0; -- i) {
			if (s.charAt(i) != t.charAt(i)) {
				break;
			}
		}
		c = n - 1 - i;

		b = n - a - c - 1;

		int cnt = 0;
		if (checkEquals(a + 1, a, b)) {
			++ cnt;
		}
		if (checkEquals(a, a + 1, b)) {
			++ cnt;
		}
		return cnt;
	}

	boolean checkEquals(int a1, int a2, int cnt) {
		for (int i = 0; i < cnt; ++ i) {
			if (s.charAt(a1 + i) != t.charAt(a2 + i)) {
				return false;
			}
		}
		return true;
	}

	boolean check2() {
		int cnt = 0;
		for (int i = 0; i < n; ++ i) {
			if (s.charAt(i) != t.charAt(i)) {
				++ cnt;
			}
		}
		return cnt == 1;
	}

	void solve() {
		in();

		if (check2()) {
			outln("2");
		} else {
			outln(check1());
		}
	}

    public static void main(String[] args) throws IOException { new E().solve(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}