package com.estudo.course.controller;

import com.estudo.course.entities.Category;
import com.estudo.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findById(@PathVariable Long categoryId){
        Category category = categoryService.findById(categoryId);
        return  ResponseEntity.ok().body(category);
    }
}
