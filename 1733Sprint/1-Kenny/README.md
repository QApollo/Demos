# OCA Demo

## Chapter 5
In chapter 5 I have learned a lot about Interfaces, Abstract classes and Polymorphism. In this small demo I'll present a small application that will highlight them all.

### UML
![Method signature](http://i.imgur.com/v5nMzuC.jpg)

#### Interfaces
```
package vehicles;

public interface Electric {
    public void setBatteryLevel(double batteryLevel);
    public double getBatteryLevel();
}
```

### Abstract Classes
```
package vehicles;

public abstract class Vehicle {
    protected int speed;

    public void move() {
        System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
    }
}
```

### Polymorphism
```
//Aston Martin Class
public void move() {
    System.out.println("The vehicle named " + name + " is moving with a speed of: " + speed);
    System.out.println("Skuuuuurrrttt");
}
```