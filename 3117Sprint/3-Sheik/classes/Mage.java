package classes;

import classes.Debug;
import interfaces.isMagic;

public class Mage extends Character implements isMagic {
	
	private final String name = "Mage";
	
	public String getName() {
		return name;
	}
	
	public String magicAttack() {
		String attack = "Fireball";
		return attack;
	}
	
	public String magicDefense() {
		String defense = "Teleport";
		return defense;
	}

}