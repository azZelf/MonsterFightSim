package labs.monster.util;

import java.util.Scanner;

public class MonsterUtil {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Pause execution and allow the user to continue by pressing ENTER.
	 */
	public static void promptEnterKey() {
		System.out.println("An Event has occured! Press \"ENTER\" to continue...");
		scanner.nextLine();
	}

}
