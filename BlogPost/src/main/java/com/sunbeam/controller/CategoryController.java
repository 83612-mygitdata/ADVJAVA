package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CategoryDTO;
import com.sunbeam.service.CategoryService;


@RestController
@RequestMapping("/Categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	public CategoryController() {
		System.out.println("in ctor "+getClass());
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addNewCategory(@RequestBody CategoryDTO dto){
		System.out.println("in add Category "+dto);
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(dto));
		}
		catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	

}
