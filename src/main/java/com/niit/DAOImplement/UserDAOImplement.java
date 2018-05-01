package com.niit.DAOImplement;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
import com.niit.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImplement implements UserDAO
{
	@Autowired
	 SessionFactory sessionFactory;

	public boolean saveOrUpdate(User user)
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		}
		catch(Exception e)
		{
		return false;
	    }
	}

	public User validateUser(String email, String password) 
	{
		
		User user;
		user= (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				                                                   .add(Restrictions.eq("email",email))
				                                                   .add(Restrictions.eq("password",password)).uniqueResult();
		if(user==null)
		{
			return null;
		}
		else
			return user;
		
	}

	public List<User> userList() 
	{
		return	sessionFactory.getCurrentSession().createQuery("from User").list();
		 
	}

	public User getUser(String email) 
	{
	   return sessionFactory.getCurrentSession().get(User.class, email);
	  	
		}

	public boolean deleteUser(String email) 
	{
		try {
			sessionFactory.getCurrentSession().delete(getUser(email));
			return true;
		}
		catch(Exception e) {
		return false;
	}
		}

}
