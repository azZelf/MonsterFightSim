package camt491.labs.monstergame;

import camt491.labs.monstergame.model.BattleBoard;
import camt491.labs.monstergame.model.Monster;

public class Game {
	
	public static void main(String[] args)
	{
//		BattleBoard battleboard = new BattleBoard();
//		battleboard.redrawBoard();
//		
//		battleboard.moveMonsters();
//		battleboard.moveMonsters();
//		battleboard.moveMonsters();
//		battleboard.moveMonsters();
		
		
		Monster m = new Monster(100, 20, 3, "BUDDY");
		
		System.out.println("Monster: " + m.name + " Health: " + m.getHealth());
		m.decreaseHealth(20);
		System.out.println("Monster: " + m.name + " New Health: " + m.getHealth());
	}

}
