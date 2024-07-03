package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostDTO;

public interface BlogPostService {
	
	ApiResponse addBlogPost(BlogPostDTO dto, Long userId);

}
