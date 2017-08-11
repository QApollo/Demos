package vehicles;

import vehicles.Car;
import vehicles.Electric;

public class Tesla extends Car implements Electric {
  	private double batteryLevel;
    // Constructor
    public Tesla() {
    	setBatteryLevel(100);
    	setSpeed(15);
    	setName("Model X");
    }

    public void setBatteryLevel(double batteryLevel) {
    	this.batteryLevel = batteryLevel;
    }
    
    public double getBatteryLevel() {
    	return batteryLevel;
    }

    public void move() {
        System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
        System.out.println("Remaining battery: " + getBatteryLevel() + "%");
    }
}