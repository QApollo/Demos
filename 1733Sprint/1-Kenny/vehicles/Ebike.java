package vehicles;
import vehicles.*;

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

}