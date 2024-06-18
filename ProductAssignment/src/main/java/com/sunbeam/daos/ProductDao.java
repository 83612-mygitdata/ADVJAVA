package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public interface ProductDao {
	
	String addProduct(Products product);
	
	Products getProductDetailsById(long id);
	
	List<Products> getProductsByPrAndCat(double min,double max,Category category);
	
	String applyDiscount(double discount,Category category);
	
	String purchaseProduct(Long id,int quantity);
	
	String deleteProduct(String name);

}
