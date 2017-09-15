package charmander;

import ispokemon.isPokemon;

public class Charmander implements isPokemon {
    private String name = "Charmander";

    public void speak() {
        System.out.println("Char Char");
    }

    public String getName() {
        return name;
    }
}
