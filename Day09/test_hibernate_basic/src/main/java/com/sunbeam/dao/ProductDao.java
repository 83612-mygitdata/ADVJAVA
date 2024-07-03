package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entites.Category;
import com.sunbeam.entites.Product;

public interface ProductDao {
	String AddProduct(Product product);
	Product getProductById(Long productId);
	
	List<Product> getAllProducts();
	
	List<Product> getProductByPriceAndCategory(double start,double end,Category userCategory);
	
	String applyDiscount(Category userCategory , double discount);
	
	String PurchaseProduct(Long productId,int quantity);
	
	String deleteProductDetails(String productName);
	
}
