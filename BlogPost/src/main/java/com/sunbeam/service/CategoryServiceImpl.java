package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CategoryDTO;
import com.sunbeam.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addCategory(CategoryDTO dto) {
		
		Category category = mapper.map(dto, Category.class);
		categoryDao.save(category);
		
		return new ApiResponse("Category is added !!!"+category);
	}

}
