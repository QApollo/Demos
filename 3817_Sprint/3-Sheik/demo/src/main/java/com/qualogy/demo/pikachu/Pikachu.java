package pikachu;

import ispokemon.IsPokemon;

public class Pikachu implements IsPokemon {
    public String name = "Pikachu";

    public void speak() {
        System.out.println("Pika Pi");
    }

    public String getName() {
        return name;
    }
}
