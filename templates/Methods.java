import java.io.*;
import java.util.*;

public class Methods {

	// time

	long t0;
	long time() { return System.currentTimeMillis(); }
	void time0() { t0 = time(); }
	void time1(String msg) { outln(msg + " t = " + (time() - t0) + "ms"); }


	// init

	Scanner in = new Scanner(System.in);

    public static void main(String[] args) { new Methods().main(); }


    // out

    static void out(Object s) { System.out.print(s + ""); }

    static void outln(Object s) { System.out.println(s + ""); }

    static void outList(Iterable list) { for (Object x : list) { out(x + " "); } outln(""); }

}