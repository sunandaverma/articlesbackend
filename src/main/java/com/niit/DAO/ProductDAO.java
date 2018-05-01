package com.niit.DAO;

import java.util.List;

import com.niit.domain.Product;
import com.niit.domain.Supplier;

public interface ProductDAO 
{

	public boolean saveProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(String pid);
	public List<Product> productList();
	public Product getProduct(String pid);
	public Supplier productSupplier(Product product);
}
