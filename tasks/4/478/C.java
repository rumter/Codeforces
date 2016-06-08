/**
 * @problem http://codeforces.com/problemset/problem/478/B
 * @status WA
 */
import java.io.*;
import java.util.*;
public class C {	
	static long t(long a, long b, long c) {
		long t;
		if (b < c) {
			t = b; b = c; c = t;
		}
		if (a < b) {
			t = a; a = b; b = t;
		}
		if (b < c) {
			t = b; b = c; c = t;
		}
		
		long k;
		
		long n = a - c;
		long m = b - c;
		k = Math.min(n / 2L, m);
		
		if (k > 0) {
			return k + t(a - k * 2L, b - k, c);
		}
		
		if (a == b && b == c) {
			return a;
		}
		
		k = Math.min(a / 2L, b + c);
		long k1 = k / 2L + k % 2L;
		long k2 = k / 2L;
		
		if (k > 0) {
			return k + t(a - k * 2L, b - k1, c - k2);
		}
		
		return c;
	}

    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String arr[] = in.readLine().split(" ");
		int r = Integer.parseInt(arr[0]);
		int g = Integer.parseInt(arr[1]);
		int b = Integer.parseInt(arr[2]);
		
		System.out.println(t(r, g, b));
    }
}