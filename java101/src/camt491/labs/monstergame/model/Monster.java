package camt491.labs.monstergame.model;

public class Monster {

	// Class Variables or Fields
	// You declare constants with final

	public final String TOMBSTONE = "Here Lies a Dead monster";

	// private fields are not visible outside of the class
	private int health;
	private int attack;
	private int movement;

	// Monitors whether the monster is alive or dead
	private boolean alive;

	// public variables are visible outside of the class
	// You should have as few as possible public fields
	private String name;
	private int xPosition;
	private int yPosition;
	private char nameChar1;

	// Class Methods
	// Accessor Methods are used to get and set the values of private fields

	public Monster() {
		this.alive = true;
		this.xPosition = 0;
		this.yPosition = 0;
	}

	public Monster(int health, int attack, int movement, String name) {
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;
		if (name != null) {
			this.nameChar1 = name.charAt(0);
		}

		this.alive = true;
		this.xPosition = 0;
		this.yPosition = 0;

	}

	// You can create multiple versions using the same method name
	// Now setHealth can except an attack that contains decimals
	// When overloading a method you can't just change the return type
	// Focus on creating methods that except different parameters

	/**
	 * Explain it here
	 * 
	 * @param decreaseHealth
	 *            explain the parameter here
	 * @return explain the return value here
	 */
	public void decreaseHealth(int decreaseHealth) {
		System.out.println("Monster: " + this.getName() + " Health: " + this.getHealth() + " is being attacked by "
				+ decreaseHealth + "!");
		this.setHealth(this.getHealth() - decreaseHealth);
		System.out.println("Monster: " + this.getName() + " new Health: " + this.getHealth());
		if (this.getHealth() <= 0) {
			this.setAlive(false);
			System.out.println("Monster: " + this.getName() + " died!");
			
		}
	}

	/**
	 * 
	 * @param decreaseHealth
	 */
	public void decreaseHealth(double decreaseHealth) {
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if (health < 0) {
			alive = false;
		}
	}

	public void attack(Monster enemy) {
		System.out.println(this.getName() + " is being attacked by " + enemy.getName());
		if (enemy.isAlive()) {
			enemy.decreaseHealth(this.getAttack());
		}
		else
		{
			System.out.println("Error: Monster cannot attack a corpse, implement a loot method!");
		}
	}
	
	public void printStatus() {
		System.out.println("\tMonster: " + this.getName() + " (firstChar: " + this.getNameChar1() + ")");
		System.out.println("\t\tHealth: " + this.getHealth() + " (alive: " + this.isAlive() + ")");
		System.out.println("\t\tAttack: " + this.getAttack());
		System.out.println("\t\tPosition(y,x): " + this.getyPosition()+ "," + this.getxPosition());
		System.out.println("\t\tMovement: " + this.getMovement());
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public char getNameChar1() {
		return nameChar1;
	}

	public void setNameChar1(char nameChar1) {
		this.nameChar1 = nameChar1;
	}

}
