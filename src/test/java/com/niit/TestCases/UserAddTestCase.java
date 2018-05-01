package com.niit.TestCases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.domain.User;

public class UserAddTestCase
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
	userDAO=(UserDAO) context.getBean("userDAO");
	user=(User) context.getBean("user");
	}

	@Test
	public void saveUserTestCase() 
	{
		user.setEmail("sunandaverma@gmail.com");
		user.setMobile("8602339915");
        user.setPassword("myusertest");
        user.setRole('A');
        user.setUsername("sunanda");
        user.setRegistrationdate(new Date());
        
        boolean flag=userDAO.saveOrUpdate(user);
      assertEquals("add user test case",true,flag);
	}

}
