package com.example.QuizeApp.ExamserviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizeApp.ExamRepository.CategoryRepository;
import com.example.QuizeApp.Examservice.CategoryService;
import com.example.QuizeApp.exammodel.Category;




@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryRepository categoryrepo;

	@Override
	public Category addCatefCategory(Category category) {
		
		return categoryrepo.save(category);
	}
	
	
	
	
	//save method using for update also

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryrepo.save(category);
		
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return   new LinkedHashSet<Category>(this.categoryrepo.findAll());
	}

	@Override
	public Category getCategory(Long cid) {
		// TODO Auto-generated method stub
		return categoryrepo.findById(cid).get();
	}

	@Override
	public void deleteCategory(Long cid) {
		// TODO Auto-generated method stub
		
		Category category=new Category();
		
		category.setCid(cid);
		
		
		categoryrepo.delete(category);
		
	}

}
