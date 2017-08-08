package vehicles;
import vehicles.*;

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

}