package com.niit.TestCases;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartDAO;
import com.niit.domain.Cart;

public class listcartcase
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Cart cart;
	
	@Autowired
	private static CartDAO cartDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cart=(Cart) context.getBean("cart");
		cartDAO=(CartDAO) context.getBean("cartDAO");
	}

	@Test
	public void cartListTestCase()
	{
		List<Cart> c = cartDAO.CartList("admin@gmail.com");
		for(Cart a:c)
		{
			System.out.println(a.getCartid()+"		"+a.getUseremail());
		}
	}

}
