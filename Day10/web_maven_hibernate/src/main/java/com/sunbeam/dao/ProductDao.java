package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entites.Product;

public interface ProductDao {
     String addProduct(Long categoreId, Product newProduct);
     String PurchaseProduct(Long productId, int quantity);
     List<Product> getAllProducts();
}
