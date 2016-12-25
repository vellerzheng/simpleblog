package com.simpleblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	HibernateTemplate ht;

	public User getUserByUserName(String username) {
		
		String hql = "from User u where u.username = ?";
		List<User> userlist = ht.find(hql, username);
		if(userlist.size()>0)
			return userlist.get(0);
		else
			return null;
		
	}

	public void loginSuccess(User dbUser) {
		// TODO Auto-generated method stub
		ht.update(dbUser);
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		ht.save(user);
	}
	


}
