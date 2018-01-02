package classes;

import interfaces.isMelee;

public class Knight extends Character implements isMelee {
	
	private final String name = "Knight";
	
	public String getName() {
		return name;
	}
	
	public String meleeAttack() {
		String attack = "Spear trust";
		return attack;
	}
	
	public String meleeDefense() {
		String defense = "Shield block";
		return defense;
	}
}