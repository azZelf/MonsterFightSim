package camt491.labs.monstergame.model;

public class Monster {

	// Class Variables or Fields
	// You declare constants with final

	public final String TOMBSTONE = "Here Lies a Dead monster";

	// private fields are not visible outside of the class
	private int health = 500;
	private int attack = 20;
	private int movement = 2;

	// Monitors whether the monster is alive or dead
	private boolean alive = true;

	// public variables are visible outside of the class
	// You should have as few as possible public fields
	public String name = "Big Monster";
	public int xPosition = 0;
	public int yPosition = 0;
	public char nameChar1 = 'B';

	// Class Methods
	// Accessor Methods are used to get and set the values of private fields

	public Monster(int health, int attack, int movement, String name) {
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;

	}

	public int getAttack() {
		return attack;
	}

	public int getMovement() {
		return movement;
	}

	public int getHealth() {
		return health;
	}

	public boolean getAlive() {
		return alive;
	}

	// You can create multiple versions using the same method name
	// Now setHealth can except an attack that contains decimals
	// When overloading a method you can't just change the return type
	// Focus on creating methods that except different parameters

	public void setHealth(int decreaseHealth) {
		health = health - decreaseHealth;
		if (health < 0) {
			alive = false;
		}
	}

	public void setHealth(double decreaseHealth) {
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if (health < 0) {
			alive = false;
		}
	}

}
