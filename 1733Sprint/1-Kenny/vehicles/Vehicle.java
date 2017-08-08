package vehicles;

public abstract class Vehicle {
    protected int speed;
    protected int seats;
    protected boolean trunk;
    protected int wheels;
    protected String name;

    public void move() {
        System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
    }

    public int getSpeed() {
    	return speed;
    }

    public void setSpeed(int speed){
    	this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}