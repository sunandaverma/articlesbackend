package com.niit.DAOImplement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.CategoryDAO;
import com.niit.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImplement implements CategoryDAO
{
	@Autowired
            SessionFactory sessionFactory;
	
	public boolean saveCategory(Category category) {
		try
		{
			 sessionFactory.getCurrentSession().save(category);
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public boolean deleteCategory(String cid) {
		try
		{
			 sessionFactory.getCurrentSession().delete(getCategory(cid));
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
		
	}

	public List<Category> getCategoriesList() {
		
		return  sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategory(String cid) {
		
		return  sessionFactory.getCurrentSession().get(Category.class,cid);
	}

	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
 
}
