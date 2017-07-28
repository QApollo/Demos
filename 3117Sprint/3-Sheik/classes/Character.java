package classes;

public abstract class Character {
	
	private final String name = "Character";
	
	public abstract String getName();
	
	public String attack() {
		String attack = "Default attack";
		return attack;
	}
	
	public String defense() {
		String defense = "Default defense";
		return defense;
	}
	
}