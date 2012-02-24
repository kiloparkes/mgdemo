package com.my.mdemo.model;

import java.util.List;



public interface Item {

	
	public BillingCode getBillingCode();

    public void setBillingCode(BillingCode billingCode);

    public String getProductIdentifier();

    public void setProductIdentifier(String productIdentifier);
    
//    public List<String> getDescriptions();
    public ItemDetails getDetails( Language language );
}
