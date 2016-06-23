package camt491.labs.monstergame.model.player;

import camt491.labs.monstergame.model.Interactable;
import camt491.labs.monstergame.model.item.Consumable;

public interface Attackable extends Interactable {
	
	public int getHealth();
	
	public void setHealth(int health);
	
	public void attack(Attackable victim);
	
	public int getAttack();
	
	public void setAttack(int attack);
	
	public boolean isAlive();
	
	public void setAlive(boolean alive);
	
	public void decreaseHealth(int decreaseHealth);
	
	public void increaseHealth(int decreaseHealth);
	
	public void consume(Consumable c);

}
