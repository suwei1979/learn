package org.suw.learn.pattern.design.composite;

import java.util.ArrayList;
import java.util.Currency;

public abstract class Equipment {
	protected Equipment() {
		
	}
	
	public String getName() {
		return name;
	}

	public abstract Watt power();
	
	public abstract Currency netPrice();
	
	public abstract Currency discountPrice();
	
	public abstract void add(Equipment part);
	
	public abstract void remove(Equipment part);
	
	public abstract ArrayList<Equipment> iterator();

	private String name;
}
