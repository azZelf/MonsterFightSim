package labs.monster.model.item.impl;

import labs.monster.model.player.Attackable;

public class HealthPotion extends Potion {
	
	public HealthPotion(int value, String name) {
		super(value, name);
	}

	@Override
	public void modifyAttackable(Attackable a) {
		a.increaseHealth(this.getValue());
	}

}
