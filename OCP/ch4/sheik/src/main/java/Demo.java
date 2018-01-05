import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Demo {

    private List<Pokemon> pokedex = new ArrayList<>();

    public static void main(String[] args) {
        new Demo();
    }

    private Demo() {
        populatePokedex();
        playerInput();
    }

    private void populatePokedex() {
        Pokemon pikachu = new Pokemon("pikachu", "electric", 1, 2,
                "male", "shock", 2, "Sheik");
        pokedex.add(pikachu);

        Pokemon bulbasaur = new Pokemon("bulbasaur", "gras", 1, 3,
                "female", "scent", 2, "Xander");
        pokedex.add(bulbasaur);

        Pokemon wartortle = new Pokemon("wartortle", "water", 2, 3,
                "male", "shock", 3, "Haoran");
        pokedex.add(wartortle);

        Pokemon charizard = new Pokemon("charizard", "fire", 3, 3,
                "female", "blaze", 4, "Aeron");
        pokedex.add(charizard);

        Pokemon eevee = new Pokemon("eevee", "normal", 1, 2,
                "male", "-", 4, "Shadab");
        pokedex.add(eevee);

        Pokemon pigeotto = new Pokemon("pigeotto", "flying", 2, 3,
                "female", "levitate", 3, "Alfonso");
        pokedex.add(pigeotto);
    }

    private void playerInput() {
        System.out.println("Please enter a pokemon name.");
        Scanner scanner = new Scanner(System.in);
        search(scanner.next());
    }

    private void search(String input) {
        Optional<Pokemon> result = pokedex.stream()
                .filter(pokemon -> pokemon.getName()
                        .contains(input))
                .findFirst();

        if (result.isPresent()) {
            print(result);
        } else {
            errorMessage();
        }
    }

    private void print(Optional<Pokemon> result) {
        System.out.println("Name: " + result.get().getName());
        System.out.println("Type: " + result.get().getType());
        System.out.println("Current Evolution Stage: " + result.get().getCurrentEvolutionStage());
        System.out.println("Maximum Evolution Stage: " + result.get().getMaximumEvolutionStage());
        System.out.println("Gender: " + result.get().getGender());
        System.out.println("Ability: " + result.get().getAbility());
        System.out.println("Number of Attacks: " + result.get().getNumberOfAttacks());
        System.out.println("Trainer: " + result.get().getTrainer());
    }

    private void errorMessage() {
        System.out.println("Pokemon not found.");
    }
}