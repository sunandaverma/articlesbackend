package com.niit.DAOImplement;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.DAO.ProductDAO;
import com.niit.domain.Product;
import com.niit.domain.Supplier;

@Transactional
@Repository("productDAO")
public class ProductDAOImplement implements ProductDAO
{
	@Autowired
	       SessionFactory sessionFactory;

	public boolean saveProduct(Product product) {
		try
		{
			 sessionFactory.getCurrentSession().save(product);
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public boolean deleteProduct(String pid) {
		try
		{
			 sessionFactory.getCurrentSession().delete(getProduct(pid));
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public List<Product> productList() {
		
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public Product getProduct(String pid) {
		
		return  sessionFactory.getCurrentSession().get(Product.class,pid);
	}
    public Supplier productSupplier(Product product) {
		
		return null;
	}

	public boolean updateProduct(Product product) {
		try
		{
			 sessionFactory.getCurrentSession().saveOrUpdate(product);
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	
	
}
