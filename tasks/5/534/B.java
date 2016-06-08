/**
 * @problem http://codeforces.com/problemset/problem/534/B
 * @status WA
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class B {
	
	int v1, v2;
	int t;
	int d;

	void in() {
		v1 = in.nextInt();
		v2 = in.nextInt();
		t = in.nextInt();
		d = in.nextInt();
	}

	int getSecondWay(int tx, int vx) {
		int dt = (t - tx);
		int dv = (v2 - vx);
		int adv = abs(dv);

		if (dt == 0) {
			if (dv == 0) {
				return vx;
			}
			return 0;
		}

		if (adv > d * dt) {
			return 0;
		}

		int dt2 = adv / d;
		int dt3 = (adv % d != 0 ? 1 : 0);
		int dt1 = dt - dt2 - dt3;

		int s = (dt1 + 1) * vx;

		int sign = (dv == 0 ? 0 : (dv > 0 ? 1 : - 1));
		int a = sign * d;
		s += vx * dt2 + a * dt2 * (dt2 + 1) * 0.5;

		if (dt3 != 0) {
			s += v2;
		}

		return s;		
	}

	int getWay() {
		int res = 0;
		int s = v1;
		int vx = v1;
		for (int tx = 1; tx < t; ++ tx) {
			int sMax = 0;
			int aMax = 0;
			for (int a = d; a >= -d; -- a) {
				int way = getSecondWay(tx + 1, vx + a);
				if (way > sMax) {
					sMax = way;
					aMax = a;
				}
			}
			vx += aMax;
			res = max(res, s + sMax);
			s += vx;
			//outln("t = " + tx + ", a = " + aMax + ", v = " + vx + ", sMax = " + sMax + ", s = " + s + ", res = " + res);
		}
		return res;
	}

	int getWayZeroD() {
		return v1 * t;
	}

	void solve() {
		if (d == 0) {
			outln(getWayZeroD());
		} else {
			outln(getWay());
		}
	}

	void main() {
		in();
		solve();
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new B().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}