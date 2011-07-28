/* 
 * $Id: Currency.java 5252 2007-02-26 14:22:16Z stube-an $
 * 
 */
package com.my.mdemo.model;

public class Currency implements java.io.Serializable {

	private static final long serialVersionUID = 5711239307338735143L;
	private Integer id;
	private String name;
	private Integer divisor;
	private String description;

	private int hashCode = Integer.MIN_VALUE;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDivisor() {
		return this.divisor;
	}

	public void setDivisor(Integer divisor) {
		this.divisor = divisor;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Currency)) {
			return false;
		}
		Currency currency = (Currency) obj;
		if (null == this.getId() || null == currency.getId()) {
			return false;
		}
		return (this.getId().equals(currency.getId()));
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
