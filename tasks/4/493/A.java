/**
 * @problem http://codeforces.com/problemset/problem/493/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		final int N = 1000;

		String hname = in.readLine();
		String aname = in.readLine();

		int n = toi(in.readLine());

		int num[] = new int[N];
		String team[] = new String[N];

		int hcntY[] = new int[N];
		int acntY[] = new int[N];
		int cnt[];

		Arrays.fill(num, 0);
		Arrays.fill(team, null);
		Arrays.fill(hcntY, 0);
		Arrays.fill(acntY, 0);

		for (int i = 0; i < n; ++ i) {
			String arr[] = in.readLine().split(" ");
			int t = toi(arr[0]);
			String tm = arr[1];
			int m = toi(arr[2]);
			String y = arr[3];

			String teamName;
			if (tm.equals("h")) {
				cnt = hcntY;
			} else {
				cnt = acntY;
			}

			if(cnt[m] < 2) {
				cnt[m] ++;
				if (y.equals("r")) {
					cnt[m] ++;
				}
				if (cnt[m] >= 2) {
					num[t] = m;
					team[t] = tm;
				}
			}
		}

		for (int i = 1; i < num.length; ++ i) {
			if (num[i] != 0) {
				String teamName;
				if (team[i].equals("h")) {
					teamName = hname;
				} else {
					teamName = aname;
				}

				out(teamName + " " + num[i] + " " + i);
			}
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}