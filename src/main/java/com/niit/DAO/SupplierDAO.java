package com.niit.DAO;

import java.util.List;

import com.niit.domain.Supplier;

public interface SupplierDAO
{
	public boolean saveSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(String sid);
	public List<Supplier> getSupplierList();
	public Supplier getSupplier(String sid);

}
