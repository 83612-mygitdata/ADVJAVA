package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addBlogPost(BlogPostDTO dto, Long userId) {
		
		User blogger = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Blogger id!!!"));
		
		Category category = categoryDao.findById(dto.getCategory_id()).orElseThrow(() -> new ResourceNotFoundException("Invalid Category id!!!"));
		System.out.println("category_id"+category);
		
		BlogPost blogPost = mapper.map(dto, BlogPost.class);
		
		BlogPost persistent = blogPostDao.save(blogPost);
		return new ApiResponse("New Post"+persistent);
	}

}
