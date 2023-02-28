package com.example.QuizeApp.exammodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


//3
//add quize id and post

@Entity
public class Question {
	
	
	
	@Id
	
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Long quesId;
	
	
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	
	private String option1;
	
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	
	
	private String answer;
	
	
	//when i get question data autometically it is fetch quize data
	@ManyToOne(fetch = FetchType.EAGER)
	private Quize quize;


	public Long getQuesId() {
		return quesId;
	}


	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}


	public String getOption5() {
		return option5;
	}


	public void setOption5(String option5) {
		this.option5 = option5;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Quize getQuize() {
		return quize;
	}


	public void setQuize(Quize quize) {
		this.quize = quize;
	}


	public Question(Long quesId, String content, String image, String option1, String option2, String option3,
			String option4, String option5, String answer, Quize quize) {
		super();
		this.quesId = quesId;
		this.content = content;
		this.image = image;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
		this.answer = answer;
		this.quize = quize;
	}


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", content=" + content + ", image=" + image + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", option5=" + option5
				+ ", answer=" + answer + ", quize=" + quize + "]";
	}

	
	
	
}
