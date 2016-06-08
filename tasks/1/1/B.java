/**
 * @problem http://codeforces.com/problemset/problem/1/B
 * @status OK
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class B {

	static final Pattern TColNRow = Pattern.compile("^([A-Z]+)(\\d+)$");
	static final Pattern RNRowCNCol = Pattern.compile("^R(\\d+)C(\\d+)$");

	static final int degree = 26;

	String transform(int ncol) {
		StringBuilder tcol = new StringBuilder("");
		while (ncol > 0) {
			char c = (char) ((ncol - 1) % degree + 'A');
			tcol.append(c);
			ncol = (ncol - 1) / degree;
		}
		return tcol.reverse().toString();
	}

	int transform(String tcol) {
		int sum = 0;
		int p = 1;
		for (int i = tcol.length() - 1; i >= 0; -- i) {
			int c = tcol.charAt(i) - 'A' + 1;
			sum += c * p;
			p *= degree;
		}
		return sum;
	}

	String execTransform(String s) {
		Matcher tnMatcher = TColNRow.matcher(s);
		if (tnMatcher.matches()) {
			String tcol = tnMatcher.group(1);
			String nrow = tnMatcher.group(2);
			return "R" + nrow + "C" + transform(tcol);
		}

		Matcher rcMatcher = RNRowCNCol.matcher(s);
		if (rcMatcher.matches()) {
			String nrow = rcMatcher.group(1);
			String ncol = rcMatcher.group(2);
			return transform(Integer.valueOf(ncol)) + nrow;
		}

		throw new IllegalArgumentException("Incorret input string: " + s);
	}

	void main() {
		int n = in.nextInt();
		for (int i = 0; i < n; ++ i) {
			outln(execTransform(in.next()));
		}

		//testTransform();
	}

	void testTransform() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("Z", 26);
		map.put("AA", 27);
		map.put("AB", 28);
		map.put("AAA", 26*26 + 26 + 1);
		map.put("AAB", 26*26 + 26 + 2);
		map.put("BAC", 2*26*26 + 26 + 3);
		map.put("AZ", 26 + 26);
		map.put("BA", 2*26 + 1);

		map.forEach((tcol, ncol) -> {
			int n = transform(tcol);
			String t = transform(ncol);
			String cn = (n == ncol) ? "YES" : "NO";
			String ct = t.equals(tcol) ? "YES" : "NO";
			outln(String.format("%s\t%s -> %d\t(%d)", cn, tcol, n, ncol));
			outln(String.format("%s\t%d -> %s\t(%s)", ct, ncol, t, tcol));
		});
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new B().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}