package com.my.mdemo.dao;

import java.util.List;

import com.my.mdemo.model.Category;


public interface CategoryDao {
	 public List<Category> getCategories(Category parent);
	 public Category getCategory(int id);
	 public int getSubCategoriesCount(final int parentId);
	 public List<Category> getSubCategories(final int parentId, final int firstResult, final int maxResults );
}
