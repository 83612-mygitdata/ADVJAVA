package com.sunbeam.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity

@Table(name="categories")
public class Category extends BaseEntity {
	//BAKERY,SHOES,CLOTHES,STATIONAY
	
	@Column(length = 25,unique=true)
	private String catName;
	
	@Column(length = 50)
	private String description;
	
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
	//Category 1-->* Product
	private List<Product> Product=new ArrayList<>();

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProduct() {
		return Product;
	}

	public void setProduct(List<Product> product) {
		Product = product;
	}
	
	/*
	 * add helper method to establish bi dir association
	 * between Category n Product
	 * */
	
	public void addProduct(Product product) {
		//product(Category)
		
		this.Product.add(product);
		product.setProductCategory(this);
	}

	@Override
	public String toString() {
		return "CategoryId "+getId()+" [catName=" + catName + ", description=" + description + ", Product=" + Product + "]";
	}
	
	
}
