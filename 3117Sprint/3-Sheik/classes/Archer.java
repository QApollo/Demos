package classes;

import interfaces.isRanged;

public class Archer extends Character implements isRanged {
	
	private final String name = "Archer";
	
	public String getName() {
		return name;
	}
	
	public String rangedAttack() {
		String attack = "Shoot arrow";
		return attack;
	}
	
	public String rangedDefense() {
		String defense = "Dodge";
		return defense;
	}
	
}