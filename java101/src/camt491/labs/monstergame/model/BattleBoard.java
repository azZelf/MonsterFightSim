package camt491.labs.monstergame.model;

import java.util.Arrays;
import java.util.Scanner;

import camt491.labs.monstergame.battle.BattleEngine;

public class BattleBoard {

	Scanner scanner = new Scanner(System.in);

	// Creates a multidimensional array of chars
	private char[][] battleBoard = new char[10][10];

	Monster[] monsters = new Monster[4];

	/**
	 * Default constructor, builds the battle board, initializes the monsters,
	 * and places the monsters on the battle board.
	 */
	public BattleBoard() {

		// Build battleBoard
		for (char[] row : battleBoard) {
			Arrays.fill(row, '*');
		}

		// Initialize Monsters

		monsters[0] = new Monster(4000, 50, 1, "Juggernaught");
		monsters[1] = new Monster(500, 350, 4, "Speedy");
		monsters[2] = new Monster(1000, 100, 2, "Paul");
		monsters[3] = new Monster(1000, 100, 2, "George");

		for (Monster m : monsters) {
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
			m.setxPosition(randNumX);
			m.setyPosition(randNumY);

			// Assign character in the array based on the first initial
			// of the monsters name charAt(0) returns first letter of name

			// Put first character of monster in the array
			battleBoard[m.getyPosition()][m.getxPosition()] = m.getNameChar1();
		}
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
					} else if (randMoveDirection == 1) {
						if ((m.getxPosition() + randMoveDistance) > maxXBoardSpace) {
							m.setyPosition(maxXBoardSpace);
						} else {
							m.setxPosition(m.getxPosition() + randMoveDistance);
						}
					} else if (randMoveDirection == 2) {
						if ((m.getyPosition() + randMoveDistance) > maxYBoardSpace) {
							m.setyPosition(maxYBoardSpace);
						} else {
							m.setyPosition(m.getyPosition() + randMoveDistance);
						}
					} else {
						if ((m.getxPosition() - randMoveDistance) < 0) {
							m.setxPosition(0);
						} else {
							m.setxPosition(m.getxPosition() - randMoveDistance);
						}
					}

					// monster.length returns the number of items in the array
					// monster
					for (int i = 0; i < monsters.length; i++) {
						// if statement skips checking the same monster position
						// against
						// itself

						if (m == monsters[i]) {
							continue;
						}

						// onMySpace returns true if the desired space is
						// occupied.
						if (onMySpace(monsters[i], m.getxPosition(), m.getyPosition())) {
							// If a monster tries to move to an occupied space
							// the monsters will fight!
							System.out.println(m.getName() + " landed on " + monsters[i].getName());
							if (monsters[i].isAlive()) { // TODO: Remove this
															// for corpse
															// looting &
															// resurrecting
								// promptEnterKey();
								BattleEngine.simulateBattle(m, monsters[i]);
								System.out.println("Interaction is over.");
								this.printMonsterStatus();
								// promptEnterKey();
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

				} // End of while loop

				// Erase monsters character on the board by replacing it with a
				// *
				battleBoard[originalyPostiion][originalxPosition] = '*';
				// Set the value in the array to the first letter of the monster
				battleBoard[m.getyPosition()][m.getxPosition()] = m.getNameChar1();
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
	private boolean onMySpace(Monster otherMon, int myDesiredXpos, int myDesiredYpos) {
		// Checks if the 2 monsters have the same x/y position
		if ((otherMon.getxPosition()) == (myDesiredXpos) && (otherMon.getyPosition()) == (myDesiredYpos)) {
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
		int aliveMonsters = monsters.length;
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
