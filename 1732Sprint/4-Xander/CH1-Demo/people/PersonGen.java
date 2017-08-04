package people;

import java.util.*;

public class PersonGen {
  String nameArray[] = {"Lisa","Max","Emma","David","Laura","Jan","Julia","Lars",
                        "Sanne","Stan","Fleur","Jesse","Anne","Floris","Merel",
                        "Tom","Anouk","Nick","Tessa","Tim"};
  String name;
  int age;

  public PersonGen() {
    this.setRandomName();
    this.setRandomAge();
  }

  public void setRandomName() {
    Random r = new Random();
    this.name = this.nameArray[r.nextInt(this.nameArray.length) + 0];
  }

  public String getName() {
    return this.name;
  }

  public void setRandomAge() {
    Random r = new Random();
    this.age = r.nextInt(86) + 1;
  }

  public int getAge() {
    return this.age;
  }
}
