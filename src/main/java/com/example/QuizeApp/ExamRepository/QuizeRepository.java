package com.example.QuizeApp.ExamRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizeApp.exammodel.Category;
import com.example.QuizeApp.exammodel.Quize;





@Repository
public interface QuizeRepository extends JpaRepository<Quize, Long> {
	
	
	public List<Quize>findByCategory(Category category);

	
	//it is alwys true
	public List<Quize>findByActive(Boolean b);
	
	public List<Quize>findByCategoryAndActive(Category category,Boolean b);
	
	
}
