package com.example.QuizeApp.Examservice;

import java.util.List;
import java.util.Set;

import com.example.QuizeApp.exammodel.Category;
import com.example.QuizeApp.exammodel.Quize;



public interface  QuizeService {
	

	public Quize addQuize(Quize quize);
	
	public Quize updateQuize(Quize quize);
	
	
	public Set<Quize>getQuizes();
	
	public Quize getQuize(Long qId);
	
public void deleteQuize(Long qId);



public List<Quize>getQuizeOfCategory(Category category);


//take it blank
public List<Quize>getActiveQuize();

public List<Quize>getActiveQuizesOfCategory(Category category);
	
	
	

}

