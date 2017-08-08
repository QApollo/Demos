package vehicles;

import vehicles.Vehicle;

public abstract class Bike extends Vehicle {
    public Bike() {
    	super();
    	seats = 1;
	    trunk = false;
	    wheels = 2;
    }
}