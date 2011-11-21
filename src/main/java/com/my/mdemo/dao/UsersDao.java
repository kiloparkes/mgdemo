package com.my.mdemo.dao;

import com.my.mdemo.model.Users;

public interface UsersDao {

	void addUser(Users user);
	
	void deleteUser(Users user);
	
	void updateUsers(Users user);
	
	Users getUser(String unsermane);

}
