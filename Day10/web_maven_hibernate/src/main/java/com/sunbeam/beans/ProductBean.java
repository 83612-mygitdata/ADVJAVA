package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entites.Product;

public class ProductBean {
	//bind request parameters to java beans props
	
	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	private long productId;
	private ProductDao productDao;
	
	public ProductBean() {
		// create Dao instence
		productDao = new ProductDaoImpl();
	    System.out.println("Product Bean Created!!!");	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	
	//bean is dependent on Dao for data mangement
	
	//Add BL Method to add a new Product
		
	
	public String addNewProduct() {
		System.out.println("in add  Product"+categoryId);
		//1.create Transient Product
		Product product = new Product(name, price, quantity);
		//2.invoke  dao's methods for saving product details in db
		return productDao.addProduct(categoryId, product);
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	
	public String PurchaseProduct() {
		
		System.out.println("in purchase " + quantity + " " + productId);
		
		return productDao.PurchaseProduct(productId, quantity);
		
	}
	

}
