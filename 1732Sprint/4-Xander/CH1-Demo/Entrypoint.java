import people.PersonGen;
import pets.PetGen;

public class Entrypoint {
  public static void main(String[] args) {
    PersonGen personOne = new PersonGen();
    PetGen petOne = new PetGen();

    System.out.println("Chapter 1 Demo");
    System.out.println("Our name is "+personOne.getName()+" and we are "+personOne.getAge()+" years old");
    System.out.println("We have a "+petOne.getSpecies()+" Named "+petOne.getName());
  }
}
