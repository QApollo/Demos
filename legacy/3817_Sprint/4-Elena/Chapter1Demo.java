// Chapter 1 Demo

// Import a package, Wildcards
//import java.nio.file.*;

// Import a package, Explicit import
import java.util.Random;

// Example Redundant Imports
//import java.lang.*; // java.lang is authomatically imported

// Naming Conflicts. 
/* Date class exists both in java.util and in java.sql
*	We need to tell java which Date class to use. 
* 	In this case java uses Date class from java.util */
//import java.util.Date;
//import java.sql.*;

// More than one class in a file
// Only one or zero classes can be public
// Public class name must equal file name, in this case class Chapter1Demo and Chapter1Demo.java
public class Chapter1Demo {
	String chapterName; // instance variable

	// Fields and Methods
	public void exampleMethod() {
		// public is access modifier; void is the return type, returns no data
		String exampleField = "simpleField";
		System.out.println("Example simple method " + exampleField);
		
		// Underscores between digits
		int a = 1_2_3_4_5_6_7; // Valid
		double b = 123_22_1_0.0_1; // Valid
		
		// Minimum and maximum for byte
		byte bMin = -128;
		byte bMax = 127;
		
		// Refference types can be assigned to null
		String s = "Hello";
		s = null; // Valid
		
		// Garbage Collection - System.gc() and finalize() are NOT guaranteed to run
		System.gc();
		
		// Primitive types can NOT be assigned to null
		//int n = null; // NOT valid - Compiler Error
		
		// Declaring and Initializing variables at once
		int myInt = 3;
		
		// Declaration and Initialization of variables separately
		int inti;
		inti = 3;
		
		// Declaring and Initializing multiple variables of same type
		int q, w = 3, ee = 4, dd, i;   // 5 variables declared, 2 variables initialized
		
		// Naming Conventions and Rules: must start with letter, $ or _ (name cannot contain other symbols)
		// sequential character can be number
		double $, $_$, __$__, abc, $1, _1, a_b_c_; // All are Valid but bad practice
		
		// Java is case-sensitive so using reserved words with different case is valid 
		String Abstract, boolEan, Break, This, While, For, If, NeW, goTo, True, False; // All are Valid but bad practice
		
		// Use Random from imported package
		Random num = new Random();
		// Generates random number between 0 (inclusive) and 3 (exclusive)
		System.out.println("Num is " + num.nextInt(3)); 
	}
	
	// Comments
	
	// Singe line comment
	
	/*
	* Multi-line comment
	*/
	
	/**
	* Javadoc comment
	*/
	
	public static void main(String[] args) {
		Chapter1Demo ch1 = new Chapter1Demo();
		ch1.exampleMethod();
		
		// Setting and Getting instance variables
		ch1.chapterName = "Java Buiding Blocks";
		System.out.println("Chapter 1: " + ch1.chapterName);
		
		Person p = new Person();
		// Set private field in Person class
		p.setName("Elena");
		// Get private field from Person class
		System.out.println("Hello " + p.getName());
		// Get public field numLegs initialized in constructor
		System.out.println("Number of legs " + p.numLegs);
		
		{System.out.println("Example of Code Block");}	
	}
	
	{System.out.println("Example of Instance Initializer");}
}

// More than one class in a file
// Classes and field
class Person {
	// Instance variables
	private String name;
	public int numLegs;
	
	// Getter method
	public String getName() {
		return name;
	}
	
	// Setter method
	public void setName(String name) {
		this.name = name;
	}
	
	// Constructor method (has no return type & name must be same as class name)
	public Person() {
		System.out.println("This is a constructor");
		// Constructor is used for initializing fields and methods
		numLegs = 2;
	}	
}