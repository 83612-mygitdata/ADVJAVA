package com.sunbeam.entites;

import javax.persistence.*;

/*
 * products table - id ,
 *  category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
 *  product name(unique)  , price , available quantity
 * */

@Entity

@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	@Column(length = 25,unique=true)
	private String product_name;
	@Column(length = 20)
	private double price;
	@Column(name="ava_quantity")
	private int ava_quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Category category, String product_name, double price, int ava_quantity) {
		super();
		this.category = category;
		this.product_name = product_name;
		this.price = price;
		this.ava_quantity = ava_quantity;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAva_quantity() {
		return ava_quantity;
	}

	public void setAva_quantity(int ava_quantity) {
		this.ava_quantity = ava_quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", product_name=" + product_name + ", price=" + price
				+ ", ava_quantity=" + ava_quantity + "]";
	}
	
	

}
