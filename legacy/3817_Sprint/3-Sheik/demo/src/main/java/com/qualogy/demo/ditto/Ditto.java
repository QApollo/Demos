package ditto;

import ispokemon.IsPokemon;

public class Ditto implements IsPokemon {
    public String name = "Ditto";

    public void speak() {
        System.out.println("...");
    }

    public String getName() {
        return name;
    }
}
