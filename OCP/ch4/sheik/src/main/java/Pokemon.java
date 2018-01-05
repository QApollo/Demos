public class Pokemon {
    private final String name;
    private final String type;
    private final int currentEvolutionStage;
    private final int maximumEvolutionStage;
    private final String gender;
    private final String ability;
    private final int numberOfAttacks;
    private final String trainer;

    public Pokemon(String name, String type, int currentEvolutionStage, int maximumEvolutionStage, String gender,
                   String ability, int numberOfAttacks, String trainer) {
        this.name = name;
        this.type = type;
        this.currentEvolutionStage = currentEvolutionStage;
        this.maximumEvolutionStage = maximumEvolutionStage;
        this.gender = gender;
        this.ability = ability;
        this.numberOfAttacks = numberOfAttacks;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCurrentEvolutionStage() {
        return currentEvolutionStage;
    }

    public int getMaximumEvolutionStage() {
        return maximumEvolutionStage;
    }

    public String getAbility() {
        return ability;
    }

    public int getNumberOfAttacks() {
        return numberOfAttacks;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getGender() {
        return gender;
    }
}
