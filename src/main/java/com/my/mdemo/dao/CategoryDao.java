package com.my.mdemo.dao;

import java.util.List;

import com.my.mdemo.model.Category;


public interface CategoryDao {
	 public List<Category> getCategories(Category parent);
	 public Category getCategory(int id);
}
