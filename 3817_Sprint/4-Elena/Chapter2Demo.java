public class Chapter2Demo {
	public static void main (String[] args) {
		
		
		// Java Statements
		
		// if statement
		int n = 3;
		if (n==3){
			System.out.println("Inside if statement");
		}
		
		// if-else statement
		if (n > 3) {
			System.out.println("n > 3, inside if-block");
		} else {
			System.out.println("n <= 3, inside else-block");
		}
		
		// Ternary operator
		int grade = 3;
		String student = grade == 3 ? "John" : "Mary"; 
		System.out.println(student);

		// switch statement
		int studentGrade;
		final int two = 2;
		switch(grade) {
			case 1:
				studentGrade = 1;
			case two:
				studentGrade = 2;
			case 3:
				studentGrade = 3;
			default:
				studentGrade = 0;
		}
		System.out.println(studentGrade);
		
		// while loop
		int emplyeeId = 1;
		while (emplyeeId < 5) {
			System.out.println("Emplyee ID is " + emplyeeId);
			emplyeeId++;
		}
		
		// do-while loop
		emplyeeId = 1;
		do {
			System.out.println("Employee " + emplyeeId + " is working.");
		}while(false);
		
		// for loop and Use of break statement
		for (int i = 1, j = 2; i < 5 && j < 6; i++, j++) {
			System.out.println("i is " + i);
			System.out.println("j is " + j);
			if (i == 3)
				System.out.println("break statement!");
				break;
		}
		
		// for-each loop
		String[] names = {"James", "Mary", "Bob"};
		for (String name : names) {
			System.out.println("Student name is " + name);
			if (name == "Mary")
				System.out.println("continue statement!");
				continue;
		}
		
		// nested loop
		OUTER_LOOP: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2)
					continue;
				if (i == 3)
					break OUTER_LOOP;
			}
		}

		// Logical Operators
		System.out.println(true && true ^ false);
		
		// Compound assignment operator
		int x = 2, y = 3;
		int p;
		int m = (p = 2);
		
		// Type casting
		short c = 1;
		short b = 2;
		int t = c + b;
		System.out.println(t);
		long ln = 109L;
		short g = (short) ln;
		float f = (float) ln;
		System.out.println("Short ln is " + g);
		System.out.println("Float ln is " + f);
	}
	
}