package com.example.QuizeApp.Examcontroller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizeApp.Examservice.QuestionService;
import com.example.QuizeApp.Examservice.QuizeService;
import com.example.QuizeApp.exammodel.Question;
import com.example.QuizeApp.exammodel.Quize;



@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	
	@Autowired
	private QuestionService service;
	
	
	@Autowired
	private QuizeService quizeservice;
	@PostMapping("/")
	public Question addQuestion(@RequestBody Question question)
	{
		return service.createQuiQuestion(question);
	}
	
	
	@PutMapping("/")
	
	public Question updateQuestion(@RequestBody Question question)
	{
		return service.updatequestion(question);
	}
	
	
	//get all questions of any qid(quize id)
	
	@GetMapping("/quize/{qId}")
	public ResponseEntity<?>getquestiobByQuize(@PathVariable("qId")Long qId)
	{
		
		
		//quize get by id
		Quize quize=this.quizeservice.getQuize(qId);
		
		
		//quize from question
	Set<Question>questions=	quize.getQuestions();
	
	
	List list=new ArrayList(questions);
	
	if (list.size()>Integer.parseInt(quize.getNumbersOfQuestions())) {
		
		list.subList(0, Integer.parseInt(quize.getNumbersOfQuestions()+1));
		
	}
	
	Collections.shuffle(list);
	
	return ResponseEntity.ok(list);
	
	
	
	}
	
	
	///
	
	//question get by quize id

	@GetMapping("/quize/all/{qId}")
	public ResponseEntity<?>getquestiobByQuizeAdmin(@PathVariable("qId")Long qId)
	{
		
		Quize quize=new Quize();
		quize.setqId(qId);
		Set<Question>questionsofquizeQuestions=this.service.getQuestionOfQuize(quize);
		return ResponseEntity.ok(questionsofquizeQuestions);
		
//		
//		//quize get by id
//		Quize quize=this.quizeservice.getQuize(qId);
//		
//		
//		//quize from question
//	Set<Question>questions=	quize.getQuestions();
//	
//	
//	List list=new ArrayList(questions);
//	
//	if (list.size()>Integer.parseInt(quize.getNumbersOfQuestions())) {
//		
//		list.subList(0, Integer.parseInt(quize.getNumbersOfQuestions()+1));
//		
//	}
//	
//	Collections.shuffle(list);
//	
//	return ResponseEntity.ok(list);
//	
//	
	
	}
	
	
	
	
	
	
	
	
	@GetMapping("/{quesId}")
	public  Question  QuestionBYiD(@PathVariable("quesId")Long quesId)
	{
		
		return service.getByQuestonId(quesId);
		
	}
	
	
	@DeleteMapping("/{quesId}")
	public void delteQuestionById(@PathVariable ("quesId")Long quesId)
	{
		this.service.deleteById(quesId);
	}
	
	
}