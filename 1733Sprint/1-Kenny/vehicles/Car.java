package vehicles;

import vehicles.Vehicle;

public abstract class Car extends Vehicle {
    public Car() {
    	super();
    	seats = 5;
	    trunk = true;
	    wheels = 4;
    }
}