package vehicles;
import vehicles.*;

public class AstonMartin extends Car implements Fuel {
  	double fuelLevel;
    String fuelType;

    // Constructor
    public AstonMartin() {
    	setFuelLevel(100);
        setFuelType("Euro 95");
    	setSpeed(12);
        setName("Vanquish");
    }

    public void setFuelLevel(double fuelLevel) {
    	this.fuelLevel = fuelLevel;
    }
    
    public double getFuelLevel() {
    	return fuelLevel;
    }

    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
    
    public String getFuelType() {
        return fuelType;
    }

    public void move() {
        System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
        System.out.println("Skuuuuurrrttt");
    }
}