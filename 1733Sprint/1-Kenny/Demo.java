import vehicles.*;
import java.util.*;

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
            
            if (v instanceof Electric) {
                System.out.println("Remaining battery: " + ((Electric)v).getBatteryLevel() + "%");

            } else if (v instanceof Fuel) {
                System.out.println("Car is using: " + ((Fuel)v).getFuelType());
                System.out.println("Fuellevel is: " + ((Fuel)v).getFuelLevel() + " liters");
            }

        }
    }

}