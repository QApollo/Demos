package squirtle;

import ispokemon.IsPokemon;

public class Squirtle implements IsPokemon {
    public String name = "Squirtle";

    public void speak() {
        System.out.println("Squirt Squirt");
    }

    public String getName() {
        return name;
    }
}
