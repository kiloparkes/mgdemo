package com.my.mdemo.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Basket {
	
	//
	Collection<ItemWrapper> c = null;

	//We will use a Sorted or unsorted Set.
	//Since a set cannot contain duplicates
	//we will increment a counter when we attempt to add
	//the same item to the basket
	
	SortedSet<ItemWrapper> treeItems = new TreeSet<ItemWrapper>();
	
	// best performing type of set
	Set<ItemWrapper> items = new HashSet<ItemWrapper>();
	
	public void empty() {
		
	}
	
	
	public Set<ItemWrapper> getItems(){
		return items;
	}
	
	public void addItem(ItemWrapper iw){
		
		if( !items.contains(iw)) {
			items.add(iw);
		}
		else {
			for (ItemWrapper i : items) {
				if(i.getItem().getProductIdentifier().equals(iw.getItem().getProductIdentifier())){
					i.setQuantity(i.getQuantity()+1);
				}
			}

		}
	}
	
	public void removeItem(){
		
	}
	
	public float getSubTotal(){
		
		float subtotal = 0;
		//Currency c = new Currency();
		int price = 0;
		for (ItemWrapper i : items) {
			Map<Currency, BillingCodePrice>  pMap = i.getItem().getBillingCode().getPrices();
			for (Currency c : pMap.keySet()) {
				if(c.getName().equals("EUR")) {
					price = i.getItem().getBillingCode().getPrices().get(c).getPrice();
					subtotal += price;
					break;
				}
			}
		}
		
		return subtotal;
	}
	
	public int getAmount() {
		
		int amt = 0;
		for (ItemWrapper i : items) {
			int q = i.getQuantity();
			amt += q;
		}
		
		return amt;
	}
}
