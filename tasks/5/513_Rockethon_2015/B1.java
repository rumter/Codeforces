/**
 * @problem http://codeforces.com/problemset/problem/513/B1
 * @status OK
 */
import java.io.*;
import java.util.*;
public class B1 {

	static int n, m;
	static int p[];

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

	static boolean nextPermutation() {
    	int i = n - 1;
    	while (i > 0 && p[i - 1] >= p[i]) {
        	i--;
    	}
    	if (i <= 0) {
        	return false;
    	}
    
    	int j = n - 1;
    	while (p[j] <= p[i - 1]){
        	j--;
    	}
    
    	swap(i - 1, j);
    	j = n - 1;
    	while (i < j) {
    		swap(i, j);
        	++ i;
        	-- j;
    	}    
    	return true;
	}

    public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		n = in.nextInt();
		m = in.nextInt();

		p = new int[n];
		for (int i = 0; i < n; ++ i) {
			p[i] = n - i;
		}

		int maxF = f();

		for (int i = 0; i < n; ++ i) {
			p[i] = i + 1;
		}

		int cnt = 0;
		do {
			if (f() == maxF) {
				++ cnt;
				if (cnt == m) {
					for (int i = 0; i < n; ++ i) {
						System.out.print(p[i] + " ");
					}
				}
			}
		} while(nextPermutation());
    }

    static int toi(String s) { return Integer.parseInt(s); }
    static long tol(String s) { return Long.parseLong(s); }
    static double tod(String s) { return Double.parseDouble(s); }
    static void log(String s) { System.out.println(s); }
    static void out(Object s) { System.out.println(s.toString()); }
}