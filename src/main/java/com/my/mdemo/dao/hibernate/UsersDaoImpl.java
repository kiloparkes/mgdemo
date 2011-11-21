package com.my.mdemo.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.my.mdemo.dao.UsersDao;
import com.my.mdemo.model.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

	@Override
	public void addUser(Users user) {
		getHibernateTemplate().merge(user);
	}

	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUsers(Users user) {
		// TODO Auto-generated method stub

	}

	public Users getUser(String username){
		
		DetachedCriteria c = DetachedCriteria.forClass(Users.class);
		c.add(Restrictions.eq("username", username));
		
		@SuppressWarnings("unchecked")
		List<Users> users = (List<Users>)getHibernateTemplate().findByCriteria(c);
		
		Users u =  (users == null || users.size() == 0) ? null : users.get(0);
		
		return u;
	}
}
