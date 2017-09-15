package bulbasaur;

import ispokemon.isPokemon;

public class Bulbasaur implements isPokemon {
    private String name = "Bulbasaur";

    public void speak() {
        System.out.println("Bulba Bulba");
    }

    public String getName() {
        return name;
    }
}
