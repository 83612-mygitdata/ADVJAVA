package com.sunbeam.dao;

import com.sunbeam.entites.Product;

public interface ProductDao {
	String AddProduct(Product product);
	Product getProductById(Long productId);
}
