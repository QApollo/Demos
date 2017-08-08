package vehicles;

import vehicles.Car;
import vehicles.Fuel;

public class AstonMartin extends Car implements Fuel {
    double fuelLevel;
    String fuelType;

    // Constructor
    public AstonMartin() {
    	setFuelLevel(50);
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
        System.out.println("Car is using: " + getFuelType());
        System.out.println("Fuellevel is: " + getFuelLevel() + " liters");
    }
}