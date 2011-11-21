package com.my.mdemo.model;

public class Authorities {

	private Integer id;
	public Users users;
	public String username;
	public String authority;

	private int hashCode = Integer.MIN_VALUE;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public boolean equals(Object o) {

		if ( o == null)
			return false;
		
		if( !(o instanceof Authorities) )
			return false;
		
		Authorities obj = (Authorities)o;
		
		if( obj == this)
			return true;
		
		if( 
				this.username.equals(obj.getUsername())
				&& this.authority.equals(obj.getAuthority())
		)
		{
			return true;
		}
		else
			return false;

	}

	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			}
			final String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
			hashCode = hashStr.hashCode();
		}
		return hashCode;
	}
	
	
}
