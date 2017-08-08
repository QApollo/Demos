package debug;

import java.util.Arrays;

public class Debug {
	public static int count = 0;

	public static void log(Object s) {
		count++;
		System.out.println("Log " + count + ":" + s);
	}

	public static void log(String[] a) {
		count++;
		System.out.println("Log " + count + ":" + Arrays.toString(a));
	}
}
