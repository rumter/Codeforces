/**
 * @problem http://codeforces.com/problemset/problem/522/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = toi(in.readLine());

		Map<String, List<String>> reps = new HashMap<String, List<String>>();
		for (int i = 0; i < n; ++ i) {
			String arr[] = in.readLine().split(" ");
			String a = arr[0].toLowerCase();
			String b = arr[2].toLowerCase();

			List<String> r;
			if (!reps.containsKey(b)) {
				r = new ArrayList<String>();
				reps.put(b, r);
			} else {
				r = reps.get(b);
			}
			r.add(a);
		}
		String a0 = "polycarp";

		List<String> q1, q2;
		q1 = new ArrayList<String>();
		q1.add(a0);

		int count = 0;
		while (!q1.isEmpty()) {
			++ count;
			q2 = new ArrayList<String>();

			for (int i = 0; i < q1.size(); ++ i) {
				List<String> r = reps.get(q1.get(i));
				if (r != null && !r.isEmpty()) {
					for (String a : r) {
						q2.add(a);
					}
				}
			}

			q1 = q2;
		}

		out(count);
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}