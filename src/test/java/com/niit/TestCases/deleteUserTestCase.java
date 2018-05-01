package com.niit.TestCases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.domain.User;

public class deleteUserTestCase
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
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	user=(User) context.getBean("user");
	userDAO=(UserDAO) context.getBean("userDAO");
	
	}

	@Test
	public void deleteUserCase()
	{
		boolean flag=userDAO.deleteUser("sunandaverma@gmail.com");
		assertEquals("delete user test case",true,flag);
		
	}

}
