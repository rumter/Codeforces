/**
 * Задача: узнать, при каких n, задачи с различными сложностями будут работать со временем 2с на моем компе.
 */
import java.io.*;
import java.util.*;

public class ON2 {

	// коэффициент
	final int k = 8;

	int time() { return (int)System.currentTimeMillis(); }

	double task1() {
		double a = 0;
		for (int i = 0; i < k; ++ i) {
			a += Math.random() * Math.random();
		}
		return a;
	}

	void taskN() {
		int n = 1000*1000;
		for (int i = 0; i < n; ++ i) {
			task1();
		}
	}

	void taskN2() {
		int n = 1000;
		for (int i = 0; i < n; ++ i) {
			for (int j = 0; j < n; ++ j) {
				task1();
			}
		}
	}

	void taskN3() {
		int n = 100;
		for (int i = 0; i < n; ++ i) {
			for (int j = 0; j < n; ++ j) {
				for (int k = 0; k < n; ++ k) {
					task1();
				}
			}
		}
	}

	void main() {

		for (int i = 0; i < 5; ++ i) {
			int t0 = time();
			taskN3();
			outln(String.format("%d: time = %d", i + 1, time() - t0));
		}

	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new ON2().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }
}