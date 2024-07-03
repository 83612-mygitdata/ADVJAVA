package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.entities.BlogPost;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired//byType
	private BlogPostDao blogPostDao;

	@Override
	public List<BlogPost> getPostByCategoryName(String catName) {
		//invoke Dao Method to get list of blog posts
		return blogPostDao.getBlogPostByCategory(catName);
	}

}
