/**
 * @problem http://codeforces.com/problemset/problem/513/B2
 * @status TL
 */
import java.io.*;
import java.util.*;
public class B2 {

	static int n;
	static long m;
	static int p[];
	static int maxF;

	static int f() {
		int sum = 0;
		for (int i = 0; i < n; ++ i) {
			for (int j = i; j < n; ++ j) {
				int min = 100 * 1000 * 1000;
				for (int k = i; k <= j; ++ k) {
					min = Math.min(min, p[k]);
				}
				sum += min;
			}
		}
		return sum;
	}

	static void swap(int i, int j) {
		int tmp = p[j]; p[j] = p[i]; p[i] = tmp;
	}

	static boolean nextPermutation(int l, int r) {
    	int i = r;
    	while (i > l && p[i - 1] >= p[i]) {
        	i--;
    	}
    	if (i <= l) {
        	return false;
    	}
    
    	int j = r;
    	while (p[j] <= p[i - 1]){
        	j--;
    	}
    
    	swap(i - 1, j);
    	j = r;
    	while (i < j) {
    		swap(i, j);
        	++ i;
        	-- j;
    	}    
    	return true;
	}

	void printAll() {
		int cnt = 0;
		do {
			if (f() == maxF) {
				++ cnt;
				System.out.print("m = " + cnt + "\t");
				//if (cnt == m) {
					for (int i = 0; i < n; ++ i) {
						System.out.print(p[i] + " ");
					}
				out("");
				//	break;
				//}
			}
		} while(nextPermutation(0, n - 1));
	}

	static void solve(long m) {
		int c1;
		long step2 = (long) Math.pow((long) 2, (long) (n - 2));
		for (c1 = 1; m > step2; ++ c1) {
			m -= step2;
			if (step2 > (long) 1) {
				step2 /= (long) 2;
			}
		}

		p[0] = c1;
		for (int i = 0; i < c1 - 1; ++ i) {
			p[n - 1 - i] = i + 1;
		}
		for (int i = 1; i < n - c1 + 1; ++ i) {
			p[i] = c1 + i;
		}

		//out("c1 = " + c1);
		//out("m = " + m);
		//out("N = " + (n - c1));
		long cnt = 0;
		do {
			if (f() == maxF) {
				++ cnt;
				if (cnt == m) {
					break;
				}
			}
		} while(nextPermutation(1, n - c1 + 1));
	}

    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		n = in.nextInt();
		m = in.nextLong();

		p = new int[n];
		for (int i = 0; i < n; ++ i) {
			p[i] = n - i;
		}
		maxF = f();

		long M = (long) Math.pow((long) 2, (long) (n - 1));

		if (m > M / (long)2) {
			solve(m);

			for (int i = 0; i < n; ++ i) {
				System.out.print(p[i] + " ");
			}
		} else {
			solve(M - m + 1);

			for (int i = n - 1; i >= 0; -- i) {
				System.out.print(p[i] + " ");
			}
		}		
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}