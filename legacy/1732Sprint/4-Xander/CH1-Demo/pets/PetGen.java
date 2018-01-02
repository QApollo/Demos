package pets;

import java.util.Random;

public class PetGen {
  String nameArray[] = {"Max","Charlie","Buddy","Rocky","Buster","Bear","Winston","Spike","Brutus"};
  String speciesArray[] = {"dog","cat","gecko","girrafe","axolotl","ferret","pet rock"};
  String species;
  String name;

  public PetGen() {
    this.setRandomName();
    this.setRandomSpecies();
  }

  public void setRandomName() {
    Random r = new Random();
    this.name = this.nameArray[r.nextInt(this.nameArray.length) + 0];
  }

  public String getName() {
    return this.name;
  }

  public void setRandomSpecies() {
    Random r = new Random();
    this.species = this.speciesArray[r.nextInt(this.speciesArray.length) + 0];
  }

  public String getSpecies() {
    return this.species;
  }

}
