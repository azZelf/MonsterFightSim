package com.camt.java.labs.guessinggame;

import java.util.Scanner;	

/**
 * Create a program that will tell you if you have guessed the random number
 * correctly.
 * 
 * Requirements:
 * 
 * (1) Your program should ask the user for a MAXIMUM number to guess.
 * (2) Your program should ask the user to guess a number between 0 and MAXIMUM.
 * (3) If the user enters a number less than 0, tell them they cannot enter a number below 0 and ask again!
 * (4) If the user enters a number above MAXIMUM, tell them they cannot enter a number above MAXIMUM and ask again!
 * (5) If the user enters something that is not a whole number, tell them to enter a whole number and ask again!
 * (6) If your user enters 0, exit the application.
 * (7) If the user does not guess the correct number, ask again!
 * (8) If the user guesses the right number, they win! Quit the application.
 * 
 */
public class GuessingGame {

	// Scan keyboard for user input
	private static Scanner userInputScanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Get maximum limit from user.
		System.out.println("Enter the maximum number." );
		int maxLimit = getPositiveWholeNumberFromUser();

		// Generate Random Number and Store
		int randomNumber = generateRandomNumber(maxLimit);

		boolean isValid = false;

		// While user does not enter a valid number or types "exit || Quit"
		// Prompt User for Guess between 0 and <max Limit>
		do {

			System.out.println("Enter a number below " + maxLimit);
			int userInput = getPositiveWholeNumberFromUser();
			isValid = isGuessValid(userInput, maxLimit);

			if (isValid) {
				isGuessCorrect(userInput, randomNumber);
				//If flow reaches this, guess was not correct, 
				// set flag back to false to loop again!
				isValid = false;
			}

		} while (!isValid);

	}

	/**
	 * Check if the guess is correct.
	 *  (1) If the guess is correct, tell the user they won and exit the application
	 *  HINT: use exitApplication();
	 *  (2) If the guess is not correct, tell the user to try again
	 *  
	 * @param userInput
	 * @param randomNumber
	 * @return
	 */
	private static void isGuessCorrect(int userInput, int randomNumber) {
		if (randomNumber == userInput) {
			System.out.println("You Win! The random number was : " + randomNumber);
			exitApplication();
		} else {
			System.out.println("Incorrect! Try Again!");
		}
	}

	/**
	 * This function:
	 *    (1) Prompts a user for a positive whole number
	 *    (2) Quits the application if the user enters 0
	 *    (3) Will prompt the user until they enter a positive whole number
	 *    (4) Tell user if they entered something that is not an whole positive number
	 *    
	 *    HINT: Try a do-while or a while loop
	 *    HINT: Implement and use isUserInputANumber()
	 *    HINT: Use exitApplication() function
	 * 
	 * @return A positive whole number from the user
	 */
	public static int getPositiveWholeNumberFromUser() {

		boolean validInput = false;
		int userInput = 0;

		do {
			System.out.println("Enter a positive whole number (0 to exit): ");

			if (!isUserInputANumber()) {
				System.out.println("You did not enter a whole number. Try Again.");
			} else {
				userInput = userInputScanner.nextInt();
				
				if (userInput > 0) {
					validInput = true;
				} 
				else if (userInput == 0) {
					exitApplication();
				} else {
					System.out.println("You did not enter a positive number.");
				}

			}

		} while (!validInput);

		return userInput;
	}
	
	/**
	 * This function checks the scanner to see if the user input a number
	 * HINT: use Scanner.hasNextInt()
	 * HINT: To discard user input that is not a number, use Scanner.next()
	 * @return
	 */
	public static boolean isUserInputANumber() {		
		if (userInputScanner.hasNextInt()) {
			return true;
		}
		else {
			userInputScanner.next();
			return false;
		}
	}

	/**
	 * This function generated a random number.
	 * The random number is:
	 *    (1) Less than the maximum number provided
	 *    (2) Greater than zero 
	 *    HINT: Math.ceil() will round up!
	 * @param max the upper limit when generating a random number
	 * @return the random number generated
	 */
	public static int generateRandomNumber(int max) {
		int randomNum = (int) Math.ceil(Math.random() * max);
		return randomNum;
	}

	/**
	 * This function checks if the guess is valid.
	 * A valid guess is :
	 *  (1) greater than 0 AND
	 *  (2) less than the maximum limit
	 * 
	 * @param guess
	 * @param max
	 * @return true if the guess is valid, otherwise false
	 */
	public static boolean isGuessValid(int guess, int max) {
		boolean isValid = false;

		if (guess > max || guess < 1) {
			System.out.println("Guess is invalid, enter a nubmer less than " + max + " and greater than zero.");
		}  else {
			isValid = true;
		}

		return isValid;
	}
	
	/**
	 * This method exits the application!
	 */
	public static void exitApplication()
	{
		System.out.println("Goodbye!");
		System.exit(0);
	}

}
