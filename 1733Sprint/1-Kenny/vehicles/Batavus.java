package vehicles;

import vehicles.Bike;

public class Batavus extends Bike {
    // Constructor
    public Batavus() {
    	setSpeed(1);
    	setName("Bryte");
    }

    public void move() {
        System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
    }
}