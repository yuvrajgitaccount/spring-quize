package com.example.QuizeApp.Examservice;

import java.util.Set;

import com.example.QuizeApp.exammodel.Category;


public interface CategoryService {
	
	
	public Category addCatefCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category>getCategories();
	
	public Category getCategory(Long cid);
	
	
	public void deleteCategory(Long cid);
	
	

}