/* 
 * $Id: BillingCodePrice.java 5252 2007-02-26 14:22:16Z stube-an $
 * 
 */
package com.my.mdemo.model;

public class BillingCodePrice implements java.io.Serializable {

	private static final long serialVersionUID = -6216316650757968647L;
	private Integer id;
	private BillingCode billingCode;
	private Currency currency;
	private Integer price;

	private int hashCode = Integer.MIN_VALUE;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public BillingCode getBillingCode() {
		return this.billingCode;
	}

	public void setBillingCode(BillingCode billingCode) {
		this.billingCode = billingCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BillingCodePrice)) {
			return false;
		}
		BillingCodePrice price = (BillingCodePrice) obj;
		if (null == this.getId() || null == price.getId()) {
			return false;
		}
		return (this.getId().equals(price.getId()));
	}

	@Override
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			}
			String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
			this.hashCode = hashStr.hashCode();
		}
		return this.hashCode;
	}

	@Override
	public String toString() {
		return this.id.toString();
	}
}
