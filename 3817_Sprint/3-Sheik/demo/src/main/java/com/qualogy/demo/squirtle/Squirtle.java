package squirtle;

import ispokemon.isPokemon;

public class Squirtle implements isPokemon {
    public String name = "Squirtle";

    public void speak() {
        System.out.println("Squirt Squirt");
    }

    public String getName() {
        return name;
    }
}
