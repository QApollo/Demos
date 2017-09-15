package bulbasaur;

import isgrasstype.IsGrassType;
import ispokemon.IsPokemon;

public class Bulbasaur implements IsPokemon, IsGrassType {
    private String name = "Bulbasaur";

    public void speak() {
        System.out.println("Bulba Bulba");
    }

    public String getName() {
        return name;
    }
}
