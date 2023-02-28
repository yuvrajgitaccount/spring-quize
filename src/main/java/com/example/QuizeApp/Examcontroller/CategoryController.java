package com.example.QuizeApp.Examcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.example.QuizeApp.Examservice.CategoryService;
import com.example.QuizeApp.exammodel.Category;



@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	
	@Autowired
	
	private CategoryService categoryservice;
	
	@PostMapping("/")
	
	
	//SAVE
	public ResponseEntity<Category>createCategoryEntity(@RequestBody Category category)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("HttpStatus.OK", "success");
		
		  Category category2=  categoryservice.addCatefCategory(category);
		
		  
		  //
		  return ResponseEntity.status(HttpStatus.OK).headers(headers).body(category2);
		
	}

	
	//UPDATE
	
	@PutMapping("/category")
	
	public ResponseEntity<Category>uPDATECategoryEntity(@RequestBody Category category)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("HttpStatus.OK", "success fully update");
		
		  Category category2=  categoryservice.updateCategory(category);
		
		  
		  //
		  return ResponseEntity.status(HttpStatus.OK).headers(headers).body(category2);
		
	}
	
	
	@GetMapping("/categoryall")
	public ResponseEntity<?>getAllCategory()
	{
		return ResponseEntity.ok(this.categoryservice.getCategories());
	}
	
	
	
	
	//it is not mandary to similar with your property name
	@GetMapping("/{cid}")
	
	public Category getCategoryById(@PathVariable("cid")Long cid)
	{
		return categoryservice.getCategory(cid);
	}
	
	
	@DeleteMapping("/{cid}")
	public void DeteteById(@PathVariable("cid")Long cid)

	{
		this.categoryservice.deleteCategory(cid);
	}
	
}

