package com.my.mdemo.service;

import java.util.List;

import com.my.mdemo.dao.CategoryDao;
import com.my.mdemo.model.Category;

public class CategoryService {

	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public List<Category> getCategories(){
		return this.categoryDao.getCategories(null);
	}
	
	public Category getCategory(int id){
		return this.categoryDao.getCategory(id);
	}
	
	public int getSubCategoriesCount( int parentId){
		return this.categoryDao.getSubCategoriesCount(parentId);
	}
	
	 public List<Category> getSubCategories(int parentId, int firstResult, 
			 			int maxResults ){
		 return this.categoryDao.getSubCategories(parentId, firstResult, maxResults);
	 }

}
