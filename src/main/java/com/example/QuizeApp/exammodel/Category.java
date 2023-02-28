package com.example.QuizeApp.exammodel;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	private String title;
	
	private String description;
	
	
	
	//when i get the data from category then quize also fetch(eager)
	//when save the category data the quize data autometically save(cased.all)
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	
	//do not want the fetch the quize data when i fartch the category data thats why using jsonIgnore
	@JsonIgnore
	private Set<Quize>quizes=new LinkedHashSet<Quize>();

	public Set<Quize> getQuizes() {
		return quizes;
	}

	public void setQuizes(Set<Quize> quizes) {
		this.quizes = quizes;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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
	
	

	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Category(Long cid, String title, String description) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", description=" + description + "]";
	}
	
}
	
	
