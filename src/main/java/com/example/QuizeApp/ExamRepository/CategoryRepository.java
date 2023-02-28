package com.example.QuizeApp.ExamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizeApp.exammodel.Category;




@Repository
public interface  CategoryRepository extends JpaRepository<Category,Long>{

}

