package com.my.mdemo.model;


public class ItemWrapper {

	private Item item;
	private int quantity = 1;
	private int hashCode = Integer.MIN_VALUE;
	private String desc1;
	private String desc2;
	
	public ItemWrapper(Item item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	
	public String getDesc1() {
		
		ItemDetails id = item.getDetails(new Language("en"));
		String desc = null;
		if( id instanceof ToneDetails){
			desc = ((ToneDetails)id).getName();
		}
		return desc;
	}
	
	public String getDesc2() {
		
		ItemDetails id = item.getDetails(new Language("en"));
		String desc = null;
		if( id instanceof ToneDetails){
			desc = "by " + ((ToneDetails)id).getArtist();
		}
		return desc;
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemWrapper)) {
			return false;
		}
		
		final ItemWrapper item = (ItemWrapper) obj;
		if (null == this.getItem().getProductIdentifier() || null == item.getItem().getProductIdentifier()) {
			return false;
		}
		return this.getItem().getProductIdentifier().equals(item.getItem().getProductIdentifier());
	}
	
	//TIP: Must override hash code if you want to use this object in a hash based collection.
	//Otherwise, the overridden equals method will not be invoked when ...
	@Override
	public int hashCode() {
		if (Integer.MIN_VALUE == hashCode) {
			if (null == this.getItem().getProductIdentifier()) {
				return super.hashCode();
			}
			final String hashStr = this.getClass().getName() + ":" + this.getItem().getProductIdentifier().hashCode();
			hashCode = hashStr.hashCode();
		}
		return hashCode;
		
	}
	
}
