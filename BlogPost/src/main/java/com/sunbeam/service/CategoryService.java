package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CategoryDTO;

public interface CategoryService {
	
	ApiResponse addCategory(CategoryDTO dto);

}
