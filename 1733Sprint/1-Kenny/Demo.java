import vehicles.Vehicle;
import vehicles.AstonMartin;
import vehicles.Tesla;
import vehicles.Ebike;
import vehicles.Batavus;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	Scanner sc = new Scanner(System.in);
	// Main
	public static void main(String args[]) {
		Demo demo = new Demo();
	}

	// Constructor
	public Demo() {
		greeting();
		createList();
		showVehicles();
	}

	private void greeting() {
		System.out.println("OCA Chapter 6 demo. Here is a list of vehicles");
	}

	private void createList() {
		vehicles.addAll(
			Arrays.asList(
				new AstonMartin(),
				new Tesla(),
				new Ebike(),
				new Batavus()
				)
			);
	}

	private void showVehicles() {
		try {
			int i = 0;
			for (Vehicle v : vehicles) {
				System.out.println(i + ") " + vehicles.get(i).getName());
				i++;
			}
		} catch (NullPointerException e) {
			System.out.println("The variable is NULL");
		} 
		System.out.println("----------------------------------------------------------------");
		System.out.println("Pick a option");
		checkInput();
	}

	private void checkInput() {
   		try {
		    String input = sc.next();
		    int result = Integer.parseInt(input);
		    showResult(result);   
	    } catch (NumberFormatException e) {
	    	System.out.println("Please enter a number");
	    }
    }

    private void showResult(int selection) {
		try {
			vehicles.get(selection).move();
		} catch(IndexOutOfBoundsException e) {
			System.out.println("The number is not valid.");
		}
    }
}