package com.niit.DAOImplement;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.SupplierDAO;
import com.niit.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImplement implements SupplierDAO
{
	@Autowired
	         SessionFactory sessionFactory;

	public boolean saveSupplier(Supplier supplier) {
		try
		{
			 sessionFactory.getCurrentSession().save(supplier);
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}
		}

	public boolean deleteSupplier(String sid) {
		try
		{
			 sessionFactory.getCurrentSession().delete(getSupplier(sid));
			 return true;
		}
		catch(Exception e)
		{
		return false;
	}}
	

	public List<Supplier> getSupplierList() {
		return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
	}

	public Supplier getSupplier(String sid) {
		
		return  sessionFactory.getCurrentSession().get(Supplier.class, sid);
	}

	

	public boolean updateSupplier(Supplier supplier) {
		try
		{
			 sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			 return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	

}
