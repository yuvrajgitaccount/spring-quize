package com.example.QuizeApp.Examservice;

import java.util.Set;

import com.example.QuizeApp.exammodel.Question;
import com.example.QuizeApp.exammodel.Quize;



public interface QuestionService {
	
	
	
	public Question createQuiQuestion(Question question);
	
	
	public Question updatequestion(Question question);
	
	
	public Set<Question>getAllQuestions();
	
	
	public Question getByQuestonId(Long quesId);
	
	
	public Set<Question>getQuestionOfQuize(Quize quize);
	
	public void deleteById(Long quesId);

}

