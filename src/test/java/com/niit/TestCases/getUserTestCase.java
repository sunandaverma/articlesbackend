package com.niit.TestCases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.domain.User;

public class getUserTestCase 
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
	public void getUserTest() 
	{
		User u=userDAO.getUser("sunandaverma@gmail.com");
		System.out.println(u.getEmail()+ "  " +u.getUsername()+"    "+u.getMobile());
	}

}
