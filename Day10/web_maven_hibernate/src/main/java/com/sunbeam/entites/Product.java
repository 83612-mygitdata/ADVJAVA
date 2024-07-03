package com.sunbeam.entites;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
	
	@Column(length = 25,unique=true)
	private String name;
	@Column(length = 20)
	private double price;
	@Column(name="available_qty")
	private int availableQty;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private Category productCategory;
	
	public Product() {
		
	}
	
	
	public Product(String name, double price, int availableQty) {
		super();
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
	}



	public Product(String name, double price, int availableQty, Category productCategory) {
		super();
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
		this.productCategory = productCategory;
	}


	public String getProduct_name() {
		return name;
	}

	public void setProduct_name(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductId "+getId()+" [name=" + name + ", price=" + price + ", availableQty=" + availableQty
				+ ", productCategory=" + productCategory + "]";
	}
	
	


}
