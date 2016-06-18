package camt491.labs.monstergame;

import camt491.labs.monstergame.model.BattleBoard;

public class Game {
	
	public static void main(String[] args)
	{
		BattleBoard battleboard = new BattleBoard();
		battleboard.redrawBoard();
		
		int i = 1;
		do{
			battleboard.moveMonsters();
			System.out.println("End turn: " + i);
			if(i%10 == 0) {
				battleboard.printMonsterStatus();
			}
			i++;
		}while(!battleboard.gameOver());
		battleboard.printMonsterStatus();
	}

}
