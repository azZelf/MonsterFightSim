package camt491.labs.monstergame.model.player.impl;

import camt491.labs.monstergame.model.item.Consumable;
import camt491.labs.monstergame.model.item.impl.HealthPotion;
import camt491.labs.monstergame.model.player.Attackable;
import camt491.labs.monstergame.model.player.Lootable;

/**
 * This Class represents a Monster.
 */
public class Monster implements Lootable, Attackable {

	// Class Variables or Fields

	// private fields are not visible outside of the class
	private String name;
	private char nameChar1;
	private int health;
	private int attack;
	private int movement; // How far a monster can move on the board.
	private int xPosition;
	private int yPosition;

	// Monitors whether the monster is alive or dead
	private boolean alive;

	// Class Methods
	// Accessor Methods (getters and setters) are used to get and set the values
	// of private fields

	public Monster() {
		this.alive = true;
		this.xPosition = 0;
		this.yPosition = 0;
	}

	public Monster(int health, int attack, int movement, String name) {
		this(); // Calls default constructor

		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;
		if (this.name != null && !this.name.isEmpty()) {
			this.nameChar1 = name.charAt(0);
		} else {
			System.out.println("ERROR: Monster name must not be null or empty.");
		}

	}

	/**
	 * Decrease the current health of a monster. If the monster's health is less
	 * than or equal to zero, the monster is dead, so the monster's alive state
	 * to false
	 * 
	 * @param decreaseHealth
	 *            The amount of health to decrease current health by.
	 */
	public void decreaseHealth(int decreaseHealth) {
		System.out.println("Monster: " + this.getName() + " Health: " + this.getHealth() + " is being attacked by "
				+ decreaseHealth + "!");
		this.setHealth(this.getHealth() - decreaseHealth);
		System.out.println("Monster: " + this.getName() + " new Health: " + this.getHealth());
		if (this.getHealth() <= 0) {
			this.setAlive(false);
			System.out.println("Monster: " + this.getName() + " is dead!");
		}
	}

	/**
	 * Increase the current health of a monster.
	 * 
	 * @param increaseHealth
	 *            The amount of health to increase current health by.
	 */
	public void increaseHealth(int increaseHealth) {
		System.out.println("Monster: " + this.getName() + " Health: " + this.getHealth() + " is being increased by "
				+ increaseHealth + "!");
		this.setHealth(this.getHealth() + increaseHealth);
		System.out.println("Monster: " + this.getName() + " new Health: " + this.getHealth());
	}

	/**
	 * Attack an enemey monster. Enemy monster will lose health equal to this
	 * monster's attack.
	 * 
	 * @param enemy
	 *            The monster being attacked by this monster.
	 */
	public void attack(Attackable enemy) {
		System.out.println(this.getName() + " is being attacked by " + enemy.getName());
		if (enemy.isAlive()) {
			enemy.decreaseHealth(this.getAttack());
		} else {
			System.out.println("Error: Monster cannot attack a corpse, implement a loot method!");
		}
	}

	/**
	 * Print the Monster's stats to the screen.
	 */
	public void printStatus() {
		System.out.println("\tMonster: " + this.getName() + " (firstChar: " + this.getNameChar1() + ")");
		System.out.println("\t\tHealth: " + this.getHealth() + " (alive: " + this.isAlive() + ")");
		System.out.println("\t\tAttack: " + this.getAttack());
		System.out.println("\t\tPosition(y,x): " + this.getyPosition() + "," + this.getxPosition());
		System.out.println("\t\tMovement: " + this.getMovement());
	}

	public void consume(Consumable c) {
		System.out.println("Monster : " + getName() + " is consuming HealthPotion of value : " + c.getValue());
		c.modifyAttackable(this);
		c.setEmpty(true);
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
