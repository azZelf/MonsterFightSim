package camt491.labs.monstergame;

import camt491.labs.monstergame.model.BattleBoard;
import camt491.labs.monstergame.model.item.impl.HealthPotion;
import camt491.labs.monstergame.model.player.impl.Monster;

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
		
		battleboard.addMonster(new Monster(4000, 50, 1, "Juggernaught"));
		battleboard.addMonster(new Monster(500, 350, 4, "Speedy"));
		battleboard.addMonster(new Monster(1000, 100, 2, "Paul"));
		battleboard.addMonster(new Monster(1000, 100, 2, "George"));
		battleboard.addMonster(new Monster(5555, 55, 5, "Fives"));
		
		battleboard.addConsumable(new HealthPotion(1000, "$HealthPotion"));
		
		battleboard.redrawBoard();

		int i = 1;
		do {
			battleboard.moveMonsters();
			System.out.println("End turn: " + i);
			i++;
		} while (!battleboard.gameOver());
	}

}
