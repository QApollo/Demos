package ditto;

import ispokemon.isPokemon;

public class Ditto implements isPokemon {
    public String name = "Ditto";

    public void speak() {
        System.out.println("...");
    }

    public String getName() {
        return name;
    }
}
