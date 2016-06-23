package camt491.labs.monstergame.interaction;

import camt491.labs.monstergame.model.item.Consumable;
import camt491.labs.monstergame.model.player.Attackable;

public class InteractionEngine {

	/**
	 * Default constructor
	 */
	public InteractionEngine() {
		// Do nothing
	}

	/**
	 * This method simulated a battle between two monsters. The monsters will
	 * take turns attacking each other until one of the monsters has no more
	 * health.
	 * 
	 * @param a1
	 *            Monster attacking, this monster will attack first
	 * @param a2
	 *            This monster attacks second.
	 * @return the victorious monster
	 */
	public static Attackable attack(Attackable a1, Attackable a2) {

		// TODO: If loot is implemented, check if monster is dead, then loot
		// items instead of battle.
		System.out.println("Monster: " + a1.getName() + " is attacking Monster: " + a2.getName());
		System.out.println("\tMonster: " + a1.getName() + " Health: " + a1.getHealth() + " Attack: " + a1.getAttack());
		System.out.println("\tMonster: " + a2.getName() + " Health: " + a2.getHealth() + " Attack: " + a2.getAttack());
		do {
			a1.attack(a2);
			if (a2.isAlive()) {
				a2.attack(a1);
			}

		} while (a1.isAlive() && a2.isAlive());
		return a1.isAlive() ? a1 : a2;
	}

}
