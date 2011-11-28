package com.my.mdemo.model;

import java.util.HashSet;
import java.util.Set;


public class Users {

	private Integer id;
	public String username;
	public String password;
	boolean enabled;
	public Set<Authorities> authorities = new HashSet<Authorities>(0);
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	//Note:
	//A convenience method
	//This ensures that both ends of the relationship are set
	public void addAuthority(Authorities auth){
		auth.setUsers(this);
		authorities.add(auth);
	}
}
