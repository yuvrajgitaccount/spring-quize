package com.example.QuizeApp.ExamserviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizeApp.ExamRepository.QuizeRepository;
import com.example.QuizeApp.Examservice.QuizeService;
import com.example.QuizeApp.exammodel.Category;
import com.example.QuizeApp.exammodel.Quize;




@Service
public class QuizeServiceImpl implements QuizeService {

	
	
	@Autowired
	private QuizeRepository quizerepo;
	
	
	@Override
	public Quize addQuize(Quize quize) {
		// TODO Auto-generated method stub
		return quizerepo.save(quize);
	}

	
	
	//you only give the id in body and it is updeted
	@Override
	public Quize updateQuize(Quize quize) {
		// TODO Auto-generated method stub
		return quizerepo.save(quize);
	}

	@Override
	public Set<Quize> getQuizes() {
		// TODO Auto-generated method stub
		return new HashSet<Quize>(this.quizerepo.findAll());
	}

	@Override
	public Quize getQuize(Long qId) {
		// TODO Auto-generated method stub
		return  quizerepo.findById(qId).get();
	}

	@Override
	public void deleteQuize(Long qId) {
		// TODO Auto-generated method stub
		
		
		
		
		 quizerepo.deleteById(qId);
	}



	@Override
	public List<Quize> getQuizeOfCategory(Category category) {
		
		return quizerepo.findByCategory(category);
	}



	@Override
	public List<Quize> getActiveQuize() {
		// TODO Auto-generated method stub
		return quizerepo.findByActive(true);
	}



	@Override
	public List<Quize> getActiveQuizesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return quizerepo.findByCategoryAndActive(category, true);
	}
 
}

