/**
 * @problem http://codeforces.com/problemset/problem/533/C
 * @status WA
 */
import java.io.*;
import java.util.*;
public class C {

	Scanner in;

	int xp, yp, xv, yv;
	int dp, dv;
	
	void in() {
		in = new Scanner(System.in);
		xp = in.nextInt();
		yp = in.nextInt();
		xv = in.nextInt();
		yv = in.nextInt();
	}

	boolean checkStopP() {
		return 	(xp == 0 && xv == 0 && yp == yv + 1) ||
				(yp == 0 && yv == 0 && xp == xv + 1);
	}

	boolean correctT(int tx, int ty, int d) {
		return 	tx <= xp && tx <= xv &&
				ty <= yp && ty <= yv &&
				tx >= 0 && ty >= 0 && d >= 0 &&
				(xp - tx) + (yp - ty) <= d &&
				Math.max(xv - tx, yv - ty) >= d;
	}

	boolean checkStopV() {
		int t1x = xp;
		int dt1 = xv - t1x;
		int t1y = yv - dt1;

		int t2y = yp;
		int dt2 = yv - t2y;
		int t2x = xv - dt2;

		return correctT(t1x, t1y, dt1) || correctT(t2x, t2y, dt2);
	}

	void solve() {
		in();

		dp = xp + yp;
		dv = Math.max(xv, yv);

		boolean resP = true;

		if (dv >= dp) {
			resP = true;
		} else if (dv < dp - 1) {
			resP = false;
		} else {
			if (checkStopP()) {
				resP = false;
			} else if (checkStopV()) {
				resP = true;
			} else {
				resP = false;
			}
		}

		outln(resP ? "Polycarp" : "Vasiliy");
	}

    public static void main(String[] args) throws IOException { new C().solve(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}