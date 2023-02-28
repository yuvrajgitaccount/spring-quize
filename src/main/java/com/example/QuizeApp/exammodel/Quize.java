package com.example.QuizeApp.exammodel;




import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

public class Quize {
	
	
	//2 add category id and post
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qId;
	
	private String title;
	
	private String description;
	
	private String maxMarks;
	
	private String numbersOfQuestions;
	
	private boolean active = false;
	
	//when i get quize id then autometic it is get category value
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	
	@OneToMany(mappedBy = "quize",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	
	//when cal the get method then it is call other wise it is not call
	@JsonIgnore
	private Set<Question>questions=new HashSet<Question>();
	
	
	

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Quize [qId=" + qId + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", numbersOfQuestions=" + numbersOfQuestions + ", active=" + active + "]";
	}

	public Quize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quize(Long qId, String title, String description, String maxMarks, String numbersOfQuestions,
			boolean active) {
		super();
		this.qId = qId;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numbersOfQuestions = numbersOfQuestions;
		this.active = active;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumbersOfQuestions() {
		return numbersOfQuestions;
	}

	public void setNumbersOfQuestions(String numbersOfQuestions) {
		this.numbersOfQuestions = numbersOfQuestions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
