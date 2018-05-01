package com.niit.DAO;

import java.util.List;

import com.niit.domain.Category;

public interface CategoryDAO
{
	
	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(String cid);
	public List<Category> getCategoriesList();
	public Category getCategory(String cid);

}
