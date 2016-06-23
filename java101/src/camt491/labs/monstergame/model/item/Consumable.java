package camt491.labs.monstergame.model.item;

import camt491.labs.monstergame.model.Interactable;
import camt491.labs.monstergame.model.player.Attackable;

public interface Consumable extends Interactable {
	
	public int getValue();
	
	public void setValue(int value);
	
	public void modifyAttackable(Attackable a);
	
	public boolean isEmpty();
	
	public void setEmpty(boolean empty);

}
