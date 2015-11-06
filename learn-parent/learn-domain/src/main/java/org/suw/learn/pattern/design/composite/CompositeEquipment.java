package org.suw.learn.pattern.design.composite;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;

public class CompositeEquipment extends Equipment {

	@Override
	public Watt power() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency netPrice() {
		ArrayList<Equipment> it = iterator();
		for (Equipment equipment : it) {
			equipment.netPrice();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency discountPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Equipment part) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Equipment part) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Equipment> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
