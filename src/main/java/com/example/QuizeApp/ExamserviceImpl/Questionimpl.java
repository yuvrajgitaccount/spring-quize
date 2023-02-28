package com.example.QuizeApp.ExamserviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizeApp.ExamRepository.QuestionRepository;
import com.example.QuizeApp.Examservice.QuestionService;
import com.example.QuizeApp.exammodel.Question;
import com.example.QuizeApp.exammodel.Quize;





@Service
public class Questionimpl implements QuestionService {
	
	
	@Autowired
	private QuestionRepository questionrepo;

	@Override
	public Question createQuiQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionrepo.save(question);
	}

	@Override
	public Question updatequestion(Question question) {
		// TODO Auto-generated method stub
		return questionrepo.save(question);
	}

	@Override
	public Set<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<Question>(this.questionrepo.findAll());
	}

	@Override
	public Question getByQuestonId(Long quesId) {
		// TODO Auto-generated method stub
		return questionrepo.findById(quesId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuize(Quize quize) {
		// TODO Auto-generated method stub
		return  this.questionrepo.findByQuize(quize);
	}

	@Override
	public void deleteById(Long quesId) {
		// TODO Auto-generated method stub
		
		Question question=new Question();
		question.setQuesId(quesId);
		
		this.questionrepo.delete(question);
		
		
	}

}
