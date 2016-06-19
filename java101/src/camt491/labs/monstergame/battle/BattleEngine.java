package camt491.labs.monstergame.battle;

import camt491.labs.monstergame.model.Monster;

public class BattleEngine {

	/**
	 * Default constructor
	 */
	public BattleEngine() {
		// Do nothing
	}

	/**
	 * This method simulated a battle between two monsters. The monsters will
	 * take turns attacking each other until one of the monsters has no more
	 * health.
	 * 
	 * @param m1
	 *            Monster attacking, this monster will attack first
	 * @param m2
	 *            This monster attacks second.
	 */
	public static Monster simulateBattle(Monster m1, Monster m2) {

		// TODO: If loot is implemented, check if monster is dead, then loot
		// items instead of battle.
		// TODO: Change method to simulate interaction which chooses actions
		// beyond simply fighting.
		// TODO: Attack, Loot, Team mate(move on), Pickup item, Stat Modifier,
		// etc.
		System.out.println("Monster: " + m1.getName() + " is attacking Monster: " + m2.getName());
		System.out.println("\tMonster: " + m1.getName() + " Health: " + m1.getHealth() + " Attack: " + m1.getAttack());
		System.out.println("\tMonster: " + m2.getName() + " Health: " + m2.getHealth() + " Attack: " + m2.getAttack());
		do {
			m1.attack(m2);
			if (m2.isAlive()) {
				m2.attack(m1);
			}

		} while (m1.isAlive() && m2.isAlive());
		return m1.isAlive() ? m1 : m2;
	}

}
