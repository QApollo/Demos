package classes;

import interfaces.isMagic;
import interfaces.isRanged;

public class Druid extends Character implements isMagic, isRanged {

	private final String name = "Druid";

	public String getName() {
		return name;
	}
	
	public String magicAttack() {
		String attack = "Entangle";
		return attack;
	}
	
	public String magicDefense() {
		String defense = "Rock skin";
		return defense;
	}
	
	public String rangedAttack() {
		String attack = "Spear throw";
		return attack;
	}
	
	public String rangedDefense() {
		String defense = "Hide";
		return defense;
	}

}