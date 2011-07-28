/* 
 * $Id: BillingCode.java 11953 2007-10-30 14:55:51Z fagur-dr $
 * 
 */
package com.my.mdemo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BillingCode implements java.io.Serializable {

	private static final long serialVersionUID = -6019496762834097739L;

	// Fields
	private Integer id;
	private String code;
	private String altCode;
	private Date created;
	private String createdBy;
	private Map<Currency, BillingCodePrice> prices = new HashMap<Currency, BillingCodePrice>();
	private Set<Tone> tones;
	private Set<Category> categories;
	private int usedByTones;
	private int usedByCategories;
	private int usedByProfiles;


	private int hashCode = Integer.MIN_VALUE;

	// Constructors

	/** default constructor */
	public BillingCode() {
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAltCode() {
		return this.altCode;
	}

	public void setAltCode(String altCode) {
		this.altCode = altCode;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<Currency, BillingCodePrice> getPrices() {
		return this.prices;
	}

	public void setPrices(Map<Currency, BillingCodePrice> prices) {
		this.prices = prices;
	}

	public Set<Tone> getTones() {
		return this.tones;
	}

	public void setTones(Set<Tone> tones) {
		this.tones = tones;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BillingCode)) {
			return false;
		}
		BillingCode billingCode = (BillingCode) obj;
		if (null == this.getId() || null == billingCode.getId()) {
			return false;
		}
		return (this.getId().equals(billingCode.getId()));
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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public int getUsedByCategories() {
		return usedByCategories;
	}

	public void setUsedByCategories(int usedByCategories) {
		this.usedByCategories = usedByCategories;
	}

	public int getUsedByProfiles() {
		return usedByProfiles;
	}

	public void setUsedByProfiles(int usedByProfiles) {
		this.usedByProfiles = usedByProfiles;
	}

	public int getUsedByTones() {
		return usedByTones;
	}

	public void setUsedByTones(int usedByTones) {
		this.usedByTones = usedByTones;
	}
	
	
	
}
