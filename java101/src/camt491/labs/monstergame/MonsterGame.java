package camt491.labs.monstergame;

import camt491.labs.monstergame.model.BattleBoard;

public class MonsterGame {
	
	public static void main(String[] args)
	{
		BattleBoard battleboard = new BattleBoard();
		battleboard.redrawBoard();
		
		battleboard.moveMonsters();
		battleboard.moveMonsters();
		battleboard.moveMonsters();
		battleboard.moveMonsters();
	}

}
