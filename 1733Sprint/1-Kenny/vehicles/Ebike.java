package vehicles;

import vehicles.Bike;
import vehicles.Electric;

public class Ebike extends Bike implements Electric {
    private double batteryLevel;
    // Constructor
    public Ebike() {
        setBatteryLevel(80);
        setSpeed(2);
        setName("Diva E-Go");
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