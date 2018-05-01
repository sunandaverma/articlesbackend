package com.niit.TestCases;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.domain.User;

public class userListTestCase
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user=(User) context.getBean("user");
		userDAO=(UserDAO) context.getBean("userDAO");
	}

	@Test
	public void userListTestCase()
	{
		List<User> u = userDAO.userList();
		for(User a:u)
		{
			System.out.println(a.getUsername()+"		"+a.getEmail()+"		"+a.getMobile()+"		"+a.getRegistrationdate());
		}
	}

}
