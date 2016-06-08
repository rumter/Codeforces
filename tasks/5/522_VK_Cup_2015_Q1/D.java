/**
 * @problem http://www.codeforces.com/problemset/problem/522/D
 * @status TL
 */
import java.io.*;
import java.util.*;
public class D {

	static final int INF = (int)1e6;

	static NavigableMap<Integer, NavigableMap<Integer, List<Integer>>> struct;
	static int[] res;

	static void buildStruct(int m, int l[], int r[]) {
		struct = new TreeMap<Integer, NavigableMap<Integer, List<Integer>>>();
		res = new int[m];
		Arrays.fill(res, -1);

		NavigableMap<Integer, List<Integer>> mapByN;
		for (int i = 0; i < m; ++ i) {
			if (!struct.containsKey(l[i])) {
				 mapByN = new TreeMap<Integer, List<Integer>>();
				 struct.put(l[i], mapByN);
			} else {
				mapByN = struct.get(l[i]);
			}

			int d = r[i] - l[i];

			List<Integer> indexes;
			if (!mapByN.containsKey(d)) {
				indexes = new ArrayList<Integer>();
				mapByN.put(d, indexes);
			} else {
				indexes = mapByN.get(d);
			}
			indexes.add(i);
		}
	}

	static void pollStruct(int x, int y) {
		NavigableMap<Integer, NavigableMap<Integer, List<Integer>>> sub = struct.headMap(x, true);
		List<NavigableMap<Integer, List<Integer>>> pollMapList = new ArrayList<NavigableMap<Integer, List<Integer>>>();

		//out("x = " + x + "; y = " + y);
		//out(sub);

		for (Map.Entry<Integer, NavigableMap<Integer, List<Integer>>> v : sub.entrySet()) {
			int vx = v.getKey();
			int needD = y - vx;
			NavigableMap<Integer, List<Integer>> pollMap = v.getValue().tailMap(needD, true);
			//out("pollMap = " + pollMap);
			if (pollMap != null && !pollMap.isEmpty()) {
				pollMapList.add(pollMap);
			}
		}

		for (NavigableMap<Integer, List<Integer>> pollMap : pollMapList) {
			//out("pollMap = " + pollMap);
			for (List<Integer> pollIndexes : pollMap.values()) {
				//out("indexes = " + pollIndexes);
				for (Integer index : pollIndexes) {
					//out("index = " + index);
					res[index] = y - x;
				}
			}
		}

		for (NavigableMap<Integer, List<Integer>> pollMap : pollMapList) {
			pollMap.clear();
		}
	}

	static class Pair implements Comparable {
		int x, y;

		public int compareTo(Object obj) {
			Pair o = (Pair)obj;
			int d1 = y - x;
			int d2 = o.y - o.x;
			if (d1 < d2) return - 1;
			if (d1 > d2) return 1;
			if (x < o.x) return - 1;
			if (x > o.x) return 1;
			if (y < o.y) return - 1;
			if (y > o.y) return 1;
			return 0;
		}

		public String toString() { return "(" + x + "; " + y + ")"; }
	}

    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		int n = in.nextInt();
		int m = in.nextInt();

		int a[] = new int[n];
		for (int i = 0; i < n; ++ i) {
			a[i] = in.nextInt();
		}

		int l[] = new int[m];
		int r[] = new int[m];
		for(int i = 0; i < m; ++ i) {
			l[i] = in.nextInt() - 1;
			r[i] = in.nextInt() - 1;
		}

		buildStruct(m, l, r);

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n; ++ i) {
			List<Integer> arr;
			if (!map.containsKey(a[i])) {
				arr = new ArrayList<Integer>();
				map.put(a[i], arr);
			} else {
				arr = map.get(a[i]);
			}
			arr.add(i);
		}

		List<Pair> q = new ArrayList<Pair>();

		for (List<Integer> arr : map.values()) {
			if (arr.size() > 1) {
				for (int i = 0; i < arr.size() - 1; ++ i) {
					Pair p = new Pair();
					p.x = arr.get(i);
					p.y = arr.get(i + 1);
					q.add(p);
				}
			}
		}

		Collections.sort(q);

		for (Pair p : q) {
			pollStruct(p.x, p.y);
		}

		for (int i = 0; i < m; ++ i) {
			out(res[i]);
		}
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}