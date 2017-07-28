// Package:
package classes;

// Import:
import java.util.Arrays;

// Class:
public class Debug {
	public static int count = 0;
	
	// Main:
	public static void main(String[] args) {
		
	}
	
	// Log:
	public static void log(Object s) {
		count++;
		System.out.println("Log " + count + ":" + s);
	}
	
	// Log arrays:
	public static void logArray(String[] a) {
		count++;
		System.out.println("Log " + count + ":" + Arrays.toString(a));
	}
}