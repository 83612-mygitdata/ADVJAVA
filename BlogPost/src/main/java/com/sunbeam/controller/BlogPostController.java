package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostDTO;
import com.sunbeam.service.BlogPostService;

@RestController
@RequestMapping("/BlogPost")
public class BlogPostController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	public BlogPostController() {
		System.out.println("in ctor "+getClass());
	}
	
	@PostMapping("/addPost/{userId}")
	public ResponseEntity<?> addNewBlogPost(@RequestBody BlogPostDTO dto , @PathVariable Long userId) {
		System.out.println("In Add BlogPost"+dto);
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(blogPostService.addBlogPost(dto,userId));	
		}catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

}
