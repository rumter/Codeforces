/**
 * @problem http://codeforces.com/problemset/problem/478/A
 * @status OK
 */
import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String arr[] = in.readLine().split(" ");
		int a[] = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; ++ i) {
			a[i] = Integer.parseInt(arr[i]);
			sum += a[i];
		}
		
		if (sum % 5 == 0 && sum != 0) {
			System.out.println((sum / 5) + "");
		} else {
			System.out.println("-1");
		}
    }
}