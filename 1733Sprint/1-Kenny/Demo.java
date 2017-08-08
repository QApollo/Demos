import vehicles.Vehicle;
import vehicles.AstonMartin;
import vehicles.Tesla;
import vehicles.Ebike;
import vehicles.Batavus;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
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
		System.out.println("OCA Chapter 5 demo. Here is a list of vehicles");
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
		for (Vehicle v : vehicles) {
			System.out.println("----------------------------------------------------------------");
			v.move();
		}
	}

}