package com.sunbeam.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="products")
public class Products {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Category category;
	
	@Column(name="product_name",length=25, unique=true)
	private String name;
	
	@Column(nullable = false)
	private double price;
	
	@Column(name="available_quantity")
	private int quantity;
	
	public Products(Category category, String name, double price, int quantity) {
		
		
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Products() {
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "Products [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	

}
