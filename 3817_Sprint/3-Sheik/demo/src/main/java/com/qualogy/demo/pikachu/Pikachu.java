package pikachu;

import ispokemon.isPokemon;

public class Pikachu implements isPokemon {
    public String name = "Pikachu";

    public void speak() {
        System.out.println("Pika Pi");
    }

    public String getName() {
        return name;
    }
}
