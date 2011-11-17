package com.my.mdemo.service;

import com.my.mdemo.dao.UsersDao;
import com.my.mdemo.model.Users;

public class UserService {
	
	UsersDao usersDao;
	
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void addUser(Users user){
		
	}
	
	public void deleteUser(Users user){
		
	}
	
	public void updateUser(Users user){
		
	}
	
	public Users getUser(int id){
		
		return null;
	}
	
	public Users getUser(String unsername){
		
		return null;
	}
}
