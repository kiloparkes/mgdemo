package com.my.mdemo.service;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;

import com.my.mdemo.dao.UsersDao;
import com.my.mdemo.model.Users;

public class UserService  {
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	private SaltSource saltSource;
	
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void addUser(Users user) throws Exception{
		
		if( this.getUser(user.getUsername()) == null){
			String pswd = encodePassowrd(user);
			user.setPassword(pswd);
			this.usersDao.addUser(user);
		}
		else{
			throw new Exception("Name in not available");
		}
	}
	
	public void deleteUser(Users user){
		
	}
	
	public void updateUser(Users user){
		
	}
	
	public Users getUser(int id){
		
		return null;
	}
	
	public Users getUser(String username){
		
		return this.usersDao.getUser(username);
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	
	private String encodePassowrd(Users user){
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		GrantedAuthority[] ga = {new GrantedAuthorityImpl("ROLE_USER")};
		Collection<GrantedAuthority> gac = Arrays.asList(ga);
		
		User userDetails = new User(user.getUsername(), user.getPassword(), 
				enabled, accountNonExpired, 
				credentialsNonExpired, accountNonLocked, gac);
		
		String encodedPassword =
			passwordEncoder.encodePassword(user.getPassword(),
					saltSource.getSalt(userDetails));
		
		return encodedPassword;
	}
}
