package camt491.labs.monstergame.model;

import java.util.Arrays;

public class BattleBoard {

	// Creates a multidimensional array of chars
	private char[][] battleBoard = new char[10][10];

	Monster[] monsters = new Monster[4];

	public BattleBoard() {
		
		//Build battleBoard
		for (char[] row : battleBoard) {
			Arrays.fill(row, '*');			
		}
		
		//Initialize Monsters
		
		
		
		monsters[0] = new Monster(1000, 20, 1, "Frank");
		monsters[1] = new Monster(500, 40, 2, "Drac");
		monsters[2] = new Monster(1000, 20, 1, "Paul");
		monsters[3] = new Monster(1000, 20, 1, "George");
		

		for (Monster m : monsters)
		{
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
			m.xPosition = randNumX;
			m.yPosition = randNumY;

			// Assign character in the array based on the first initial
			// of the monsters name charAt(0) returns first letter of name
			m.nameChar1 = m.name.charAt(0);

			// Put first character of monster in the array
			battleBoard[m.yPosition][m.xPosition] = m.nameChar1;
		}
	}

	// Redraws the board
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

	public void moveMonsters() {
		// isSpaceOpen will be used to track whether the space the
		// monster plans to move into is occupied
		boolean isSpaceOpen;
		
		
		for (Monster m : monsters) {
			if (m.getAlive()) {
				
				isSpaceOpen = true;

				// Define the maximum x and y for the battle board
				// It's 1 less because the array index starts at 0
				int maxXBoardSpace = battleBoard.length - 1;
				int maxYBoardSpace = battleBoard[0].length - 1;

				// while loop used to make sure I don't move a monster
				// into an occupied space
				while (isSpaceOpen) {

					// Randomly generate move direction N, S, E, or W
					int randMoveDirection = (int) (Math.random() * 4);

					// Randomly generate move distance based on max move distance
					int randMoveDistance = (int) (Math.random() * (m.getMovement() + 1));

					// Prints move distance and move direction
					System.out.println("Monster " + m.nameChar1 + " Moving - distance: "+randMoveDistance + " direction: " + randMoveDirection);

					// Erase monsters character on the board by replacing it with a *
					battleBoard[m.yPosition][m.xPosition] = '*';

					if (randMoveDirection == 0) {
						// Find new xPosition & yPosition based on the current position
						// on the board
						// If statements won't allow monster to move off the board

						if ((m.yPosition - randMoveDistance) < 0) {
							m.yPosition = 0;
						} else {
							m.yPosition = m.yPosition - randMoveDistance;
						}
					} else if (randMoveDirection == 1) {
						if ((m.xPosition + randMoveDistance) > maxXBoardSpace) {
							m.xPosition = maxXBoardSpace;
						} else {
							m.xPosition = m.xPosition + randMoveDistance;
						}
					} else if (randMoveDirection == 2) {
						if ((m.yPosition + randMoveDistance) > maxYBoardSpace) {
							m.yPosition = maxYBoardSpace;
						} else {
							m.yPosition = m.yPosition + randMoveDistance;
						}
					} else {
						if ((m.xPosition - randMoveDistance) < 0) {
							m.xPosition = 0;
						} else {
							m.xPosition = m.xPosition - randMoveDistance;
						}
					}

					// monster.length returns the number of items in the array monster
					for (int i = 0; i < monsters.length; i++) {
						// if statement skips checking the same monster position against
						// itself

						if (m == monsters[i]) {
							continue;
						}

						// onMySpace receives the monster array, index for the object
						// I'm
						// checking currently, and the index for the monster sent to
						// this function

						if (onMySpace(monsters[i], m.xPosition, m.yPosition)) {
							// If a monster tries to move to an occupied space the
							// while loop repeats after I break out of the for loop

							isSpaceOpen = true;
							break;
						} else {
							// There was no monster in the space so end the while loop
							isSpaceOpen = false;

						}

					}

				} // End of while loop

				// Set the value in the array to the first letter of the monster
				battleBoard[m.yPosition][m.xPosition] = m.nameChar1;
			}
		}
		redrawBoard();
		
	}

	// Checks if a monster is trying to move into the same x/y position as
	// another monster
	public boolean onMySpace(Monster m, int myDesiredXpos, int myDesiredYpos) {
		// Checks if the 2 monsters have the same x/y position
		if ((m.xPosition) == (myDesiredXpos)
				&& (m.yPosition) == (myDesiredYpos)) {
			// If they are equal return true so a new x/y position is calculated

			return true;

		} else {

			// If false I know the x/y position isn't occupied
			return false;
		}
	}

}
