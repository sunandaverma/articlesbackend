package com.niit.TestCases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.domain.Supplier;

public class SupplierTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplier=(Supplier) context.getBean("supplier");
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	}
	
	@Test
	public void addsuppliertestcase()
	{
		supplier.setSid("222");
		supplier.setSname("sunanda");
		supplier.setSaddress("Delhi");
		
		boolean flag = supplierDAO.saveSupplier(supplier);
		assertEquals("add supplier test case", true, flag);
	}

}
