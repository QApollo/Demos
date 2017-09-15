package charmander;

import ispokemon.IsPokemon;

public class Charmander implements IsPokemon {
    private String name = "Charmander";

    public void speak() {
        System.out.println("Char Char");
    }

    public String getName() {
        return name;
    }
}
