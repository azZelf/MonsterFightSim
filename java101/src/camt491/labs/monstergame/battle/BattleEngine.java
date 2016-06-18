package camt491.labs.monstergame.battle;

import camt491.labs.monstergame.model.Monster;

public class BattleEngine {
	
	public BattleEngine() {
	}
	
	public static void simulateBattle(Monster m1, Monster m2) {
		
		//TODO: Check if monster is dead, then loot instead of battle.
		//TODO: Change method to simulate interaction which decides what to do.
		//TODO: Attack, Loot, Team mate(move on), Pickup item, Stat Modifier, etc.
		do {
			System.out.println("Monster: " + m1.getName() + " is attacking Monster: " + m2.getName());
			System.out.println("\tMonster: " + m1.getName() + " Health: " + m1.getHealth() + " Attack: " + m1.getAttack());
			System.out.println("\tMonster: " + m2.getName() + " Health: " + m2.getHealth() + " Attack: " + m2.getAttack());
			m1.attack(m2);
			if(m2.isAlive()) {
				m2.attack(m1);
			}
			
		}while(m1.isAlive() && m2.isAlive());
	}	

}
