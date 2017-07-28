import classes.Debug;

import classes.Character;
import classes.Archer;
import classes.Druid;
import classes.Knight;
import classes.Mage;
import classes.Paladin;
import classes.Ranger;

import interfaces.isMagic;
import interfaces.isMelee;
import interfaces.isRanged;

import java.util.Arrays;
import java.util.ArrayList;

public class ApolloFightv2 {

	private static final String RANGED = "isRanged";
	private static final String MAGIC = "isMagic";
	private static final String MELEE = "isMelee";

	public static void main(String[] args) {
			ApolloFightv2 apolloFight = new ApolloFightv2();
	}

	private ApolloFightv2() {
		createCharacters();
	}

	private void createCharacters() {
		ArrayList<Character> characterList = new ArrayList<>();

		Archer a = new Archer();
		Druid d = new Druid();
		Knight k = new Knight();
		Mage m = new Mage();
		Paladin p = new Paladin();
		Ranger r = new Ranger();

		characterList.addAll(Arrays.asList(a, d, k, m, p, r));

		for (Character character : characterList) {
			displayCharacters(character);
		}
	}

	private void displayCharacters(Character character) {
		System.out.println("\n" + character.getName());

		int numberOfTypes = getNumberOfTypes(character);

		for (int i = 0; i < numberOfTypes; i++) {
			String characterType = getType(character, i);
			switch(characterType) {
				case RANGED:
					isRanged rangedChar = (isRanged)character;
					System.out.println("ATK: " + rangedChar.rangedAttack());
					System.out.println("DEF: " + rangedChar.rangedDefense());
					break;
				case MAGIC:
					isMagic magicChar = (isMagic)character;
					System.out.println("ATK: " + magicChar.magicAttack());
					System.out.println("DEF: " + magicChar.magicDefense());
					break;
				case MELEE:
					isMelee meleeChar = (isMelee)character;
					System.out.println("ATK: " + meleeChar.meleeAttack());
					System.out.println("DEF: " + meleeChar.meleeDefense());
					break;
				default:
					System.out.println("ATK: " + character.attack());
					System.out.println("DEF: " + character.defense());
					break;
			}
		}
	}

	private int getNumberOfTypes(Character c) {
			int numberOfTypes = c.getClass().getInterfaces().length;
			return numberOfTypes;
	}

	private String getType(Character c, int i) {
			String type = Arrays.asList(c.getClass().getInterfaces()).get(i).getSimpleName();
			return type;
	}
}
