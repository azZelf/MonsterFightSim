package labs.monster.model.item;

import labs.monster.model.Interactable;
import labs.monster.model.player.Attackable;

public interface Consumable extends Interactable {
	
	public int getValue();
	
	public void setValue(int value);
	
	public void modifyAttackable(Attackable a);
	
	public boolean isEmpty();
	
	public void setEmpty(boolean empty);

}
