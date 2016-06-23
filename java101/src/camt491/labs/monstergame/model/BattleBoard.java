package camt491.labs.monstergame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import camt491.labs.monstergame.interaction.InteractionEngine;
import camt491.labs.monstergame.model.item.Consumable;
import camt491.labs.monstergame.model.player.impl.Monster;
import camt491.labs.monstergame.util.MonsterUtil;

public class BattleBoard {

	Scanner scanner = new Scanner(System.in);

	// Creates a multidimensional array of chars
	private char[][] battleBoard = new char[10][10];

	List<Monster> monsters = new ArrayList<>();
	List<Consumable> consumables = new ArrayList<>();

	/**
	 * Default constructor, builds the battle board, initializes the monsters,
	 * and places the monsters on the battle board.
	 */
	public BattleBoard() {

		// Build battleBoard
		for (char[] row : battleBoard) {
			Arrays.fill(row, '*');
		}
	}

	public void addMonster(Monster m) {
		// TODO: EXTRA CREDIT Check to see if board is full
		monsters.add(m);
		addInteractableToBoard(m);

	}
	
	public void addConsumable(Consumable c) {
		// TODO: EXTRA CREDIT Check to see if board is full
		consumables.add(c);
		addInteractableToBoard(c);
	}
	

	private void addInteractableToBoard(Interactable i) {
		// TODO: EXTRA CREDIT Check to see if board is full
		// Define the maximum x and y for the battle board
		// It's 1 less because the array index starts at 0
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;

		// The random starting position for a monster
		int randNumX, randNumY;

		// We use a do loop because we always want to define a start
		// position for each monster

		do {
			// Calculate start position based on max board space
			randNumX = (int) (Math.random() * maxXBoardSpace);
			randNumY = (int) (Math.random() * maxYBoardSpace);
		} while (battleBoard[randNumY][randNumX] != '*');
		// Only allow monster to start on a space with a * on it

		// Assign x and y position to the object that called this method
		i.setxPosition(randNumX);
		i.setyPosition(randNumY);

		// Assign character in the array based on the first initial
		// of the monsters name charAt(0) returns first letter of name

		// Put first character of monster in the array
		battleBoard[i.getyPosition()][i.getxPosition()] = i.getNameChar1();
	}

	/**
	 * Redraws the battle board, printing it to the screen.
	 */
	public void redrawBoard() {

		int k = 1;
		while (k <= 30) {
			System.out.print('-');
			k++;
		}
		System.out.println();

		for (int i = 0; i < battleBoard.length; i++) {
			for (int j = 0; j < battleBoard[i].length; j++) {
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			System.out.println();

		}
		k = 1;
		while (k <= 30) {
			System.out.print('-');
			k++;
		}
		System.out.println();
	}

	/**
	 * Moves all the monsters in a random direction based on their "movement"
	 * stat. If a monster lands on another monster, they enter a battle.
	 * Monsters cannot move off the board, and will stop at the edges.
	 */
	public void moveMonsters() {
		// isSpaceOpen will be used to track whether the space the
		// monster plans to move into is occupied
		boolean isSpaceOccupied;

		for (Monster m : monsters) {
			if (m.isAlive()) {
				isSpaceOccupied = true;

				// Define the maximum x and y for the battle board
				// It's 1 less because the array index starts at 0
				int maxXBoardSpace = battleBoard.length - 1;
				int maxYBoardSpace = battleBoard[0].length - 1;

				int originalxPosition = m.getxPosition();
				int originalyPostiion = m.getyPosition();

				char newBoardValue = m.getNameChar1();

				// while loop used to make sure I don't move a monster
				// into an occupied space
				while (isSpaceOccupied) {

					// Randomly generate move direction N, S, E, or W
					int randMoveDirection = (int) (Math.random() * 4);

					// Randomly generate move distance based on max move
					// distance
					int randMoveDistance = (int) (Math.random() * (m.getMovement() + 1));

					// Prints move distance and move direction
					System.out.println("Monster " + m.getNameChar1() + " Moving - distance: " + randMoveDistance
							+ " direction: " + randMoveDirection);

					if (randMoveDirection == 0) {
						// Find new xPosition & yPosition based on the current
						// position
						// on the board
						// If statements won't allow monster to move off the
						// board

						if ((m.getyPosition() - randMoveDistance) < 0) {
							m.setyPosition(0);
						} else {
							m.setyPosition(m.getyPosition() - randMoveDistance);
						}
					} else if (randMoveDirection == 1) { //
						if ((m.getxPosition() + randMoveDistance) > maxXBoardSpace) {
							m.setyPosition(maxXBoardSpace);
						} else {
							m.setxPosition(m.getxPosition() + randMoveDistance);
						}
					} else if (randMoveDirection == 2) { //
						if ((m.getyPosition() + randMoveDistance) > maxYBoardSpace) {
							m.setyPosition(maxYBoardSpace);
						} else {
							m.setyPosition(m.getyPosition() + randMoveDistance);
						}
					} else { // Left
						if ((m.getxPosition() - randMoveDistance) < 0) {
							m.setxPosition(0);
						} else {
							m.setxPosition(m.getxPosition() - randMoveDistance);
						}
					}

					
					for (Monster m2 : monsters) {
						// if statement skips checking the same monster position
						// against
						// itself

						if (m == m2) {
							continue;
						}

						// onMySpace returns true if the desired space is
						// occupied.
						if (onMySpace(m2, m.getxPosition(), m.getyPosition())) {
							// If a monster tries to move to an occupied space
							// the monsters will fight!
							System.out.println(m.getName() + " landed on " + m2.getName());
							if (m2.isAlive()) { // TODO: Remove
																// this
																// for corpse
																// looting &
																// resurrecting
								// MonsterUtil.promptEnterKey();
								newBoardValue = InteractionEngine.attack(m, m2).getNameChar1();
								System.out.println("Interaction is over.");
								this.printMonsterStatus();
								// MonsterUtil.promptEnterKey();
							}
							isSpaceOccupied = false; // TODO: Set to true if the
														// monster cannot land
														// on the space, reset
														// position to original
														// position before
														// continuing
							break;
						} else {
							// There was no monster in the space so end the
							// while loop
							isSpaceOccupied = false;

						}

					}
					
					for(Consumable c : consumables) {
						if(!c.isEmpty()) {
							if (onMySpace(c, m.getxPosition(), m.getyPosition())) {
								// If a monster tries to move to an occupied space
								// the monsters will fight!
								System.out.println(m.getName() + " landed on " + c.getName());
								MonsterUtil.promptEnterKey();
								m.consume(c);
								newBoardValue = m.getNameChar1();
								System.out.println("Interaction is over.");
								this.printMonsterStatus();
								MonsterUtil.promptEnterKey();
								break;
							}
						}
					}
					//TODO: Not using right now
					isSpaceOccupied = false;

				} // End of while loop

				// Erase monsters character on the board by replacing it with a
				// *
				battleBoard[originalyPostiion][originalxPosition] = '*';
				// Set the value in the array to the first letter of the monster
				battleBoard[m.getyPosition()][m.getxPosition()] = newBoardValue;
			}
		}
		redrawBoard();

	}

	/**
	 * Checks to see if the space is occupied.
	 * 
	 * @param otherMon
	 *            Monster that could potentially be on the desired space
	 * @param myDesiredXpos
	 *            Desired x position
	 * @param myDesiredYpos
	 *            Desired y position
	 * @return
	 */
	private boolean onMySpace(Interactable otherThing, int myDesiredXpos, int myDesiredYpos) {
		// Checks if the 2 monsters have the same x/y position
		if ((otherThing.getxPosition()) == (myDesiredXpos) && (otherThing.getyPosition()) == (myDesiredYpos)) {
			// If they are equal return true
			return true;
		} else {
			// If false, the x/y position isn't occupied
			return false;
		}
	}

	/**
	 * The game is over when only one monster remains. Check all monsters to
	 * determine the number of alive monsters. If the game is over, print the
	 * name of the victor.
	 * 
	 * @return true if only one monster is alive, otherwise false
	 */
	public boolean gameOver() {
		Monster victor = null;
		int aliveMonsters = monsters.size();
		for (Monster m : this.monsters) {
			if (!m.isAlive()) {
				aliveMonsters--;
			} else {
				victor = m;
			}
			System.out.println("Monster : " + m.getName() + " Alive : " + m.isAlive());
		}
		if (aliveMonsters <= 1) {
			System.out.println("THE WINNER IS : " + victor.getName() + "!!!!!!");
			return true;
		} else
			return false;
	}

	/**
	 * Print the status of all the monsters
	 */
	public void printMonsterStatus() {
		System.out.println("----Start Print----");
		for (Monster m : this.monsters) {
			m.printStatus();
		}
		System.out.println("-----End  Print----");
	}

	/**
	 * Pause execution and allow the user to continue by pressing ENTER.
	 */
	public void promptEnterKey() {
		System.out.println("An Event has occured! Press \"ENTER\" to continue...");
		scanner.nextLine();
	}

}
