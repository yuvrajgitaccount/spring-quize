package com.example.QuizeApp.ExamRepository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizeApp.exammodel.Question;
import com.example.QuizeApp.exammodel.Quize;




@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	
	
	
	//QUIZE IS SMILAR WITH YOUR VARIABLE NAME
	Set<Question> findByQuize(Quize quize);

}

