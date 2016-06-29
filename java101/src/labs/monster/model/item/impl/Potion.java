package labs.monster.model.item.impl;

import labs.monster.model.Interactable;
import labs.monster.model.item.Consumable;
import labs.monster.model.player.Attackable;

public abstract class Potion implements Interactable, Consumable {

	private String name;
	
	private char nameChar1;
	
	private int value;
	
	private boolean empty;

	private int xPosition;

	private int yPostition;

	public Potion() {
		//TODO: Extend Entity Class to set name and x and y position for all monsters and items then extend
		this.value = 0;
		this.xPosition = 0;
		this.yPostition = 0;
		this.empty = false;
	}
	
	public Potion(int value, String name) {
		this();
		this.value = value;
		this.name = name;
		this.nameChar1 = name.charAt(0);
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int getxPosition() {
		return this.xPosition;
	}

	@Override
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;

	}

	@Override
	public int getyPosition() {
		return this.yPostition;
	}

	@Override
	public void setyPosition(int yPosition) {
		this.yPostition = yPosition;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public char getNameChar1() {
		return this.nameChar1;
	}

	@Override
	public void setNameChar1(char c) {
		this.nameChar1 = c;
		
	}
	
	@Override
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	@Override
	public boolean isEmpty() {
		return this.empty;
	}

	@Override
	public abstract void modifyAttackable(Attackable a);

}
