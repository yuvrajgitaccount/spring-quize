package com.example.QuizeApp.Examcontroller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.QuizeApp.Examservice.QuizeService;
import com.example.QuizeApp.exammodel.Category;
import com.example.QuizeApp.exammodel.Quize;


@RestController
@RequestMapping("/quize")
@CrossOrigin("*")
public class QuizeControlller {
	
	
	
	@Autowired
	private QuizeService service;
	//addvalue
	@PostMapping("/")
	
	public ResponseEntity<Quize>addQuizEntity(@RequestBody Quize quize)
	
	{
		
		return ResponseEntity.ok(this.service.addQuize(quize));
		
	}

	
	
	@PutMapping("/quize")
public ResponseEntity<Quize>updateQuizEntity(@RequestBody Quize quize)
	
	{
		
		return ResponseEntity.ok(this.service.updateQuize(quize));
		
}
	
	@GetMapping("/quizeall")
	public ResponseEntity<Set<Quize>>getAll()
	{
		Set<Quize>set=  service.getQuizes();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(set);
		
	}
	
	
	@GetMapping("/{qId}")
	public Quize getByquizeId(@PathVariable("qId")Long qId )
	{
		
		
		
		return this.service.getQuize(qId);
	}
	
	
	@DeleteMapping("/{qId}")
	
	public void deleteByID(@PathVariable("qId")Long qId)
	{
		this.service.deleteQuize(qId);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quize>getQuizeOfCategory(@PathVariable ("cid")Long cid )
	{
		Category category=new Category();
		category.setCid(cid);
		
		return this.service.getQuizeOfCategory(category);
		
	}
	
	@GetMapping("/active")
	public List<Quize>getQuizeOfActive()
	{
		return this.service.getActiveQuize();
	}
	
	
	@GetMapping("/category/active/{cid}")
	public List<Quize>getActiveQuizeOfCategory(@PathVariable("cid")Long cid)
	{
		Category category=new Category();
		category.setCid(cid);
		
		
		return this.service.getActiveQuizesOfCategory(category);
		
	}
	
}
