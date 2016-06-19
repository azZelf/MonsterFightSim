package camt491.labs.monstergame;

import camt491.labs.monstergame.model.BattleBoard;

/**
 * This class runs the Monster Battle Simulation!
 */
public class Game {

	/**
	 * Initialize the battle board. Run the simulation until the game is over,
	 * and only one monster lives.
	 * 
	 * @param args
	 *            Not used
	 */
	public static void main(String[] args) {
		BattleBoard battleboard = new BattleBoard();
		battleboard.redrawBoard();

		int i = 1;
		do {
			battleboard.moveMonsters();
			System.out.println("End turn: " + i);
			i++;
		} while (!battleboard.gameOver());
	}

}
