/**
 * @problem http://codeforces.com/problemset/problem/478/B
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B {
	
	static long k(long n) {
		return n * (n - 1L) / 2L;
	}
	
	static long kmin(long n, long m) {
		long x = n / m;
		long y = n % m;
		return k(x + 1L) * y + k(x) * (m - y);
	}
	
	static long kmax(long n, long m) {
		return k(n - m + 1L);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String arr[] = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		System.out.println(kmin(n, m) + " " + kmax(n, m));
    }
}