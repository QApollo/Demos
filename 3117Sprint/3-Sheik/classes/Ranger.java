package classes;

import interfaces.isMelee;

public class Ranger extends Archer implements isMelee {

	private final String name = "Ranger";
	
	public String getName() {
		return name;
	}
	
	public String meleeAttack() {
		String attack = "Sword swing";
		return attack;
	}
	
	public String meleeDefense() {
		String defense = "Block";
		return defense;
	}

}