package debug;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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

	public static void log(ArrayList list) {
		count++;
		list.forEach(System.out::println);
	}
}
