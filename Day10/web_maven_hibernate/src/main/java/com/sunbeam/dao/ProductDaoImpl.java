package com.sunbeam.dao;

import com.sunbeam.entites.Category;
import com.sunbeam.entites.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoreId, Product newProduct) {
		String msg = "Added Product Failed !!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//get category from its id
			Category category = session.get(Category.class, categoreId);
			if(category != null)
			{
				//Vaild category - Persistent
				//establish bi-directional association between Category and Product
				category.addProduct(newProduct);
				//session.persist(newProduct);
				msg="Added The Product";
			}
			tx.commit();
			/*
			 * session.flush()-> dirty Cheking
			 * Category is Modified -> new product entity added.
			 * hib: insert the Product
			 * */
			
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}
	
	public String PurchaseProduct(Long productId, int quantity) {
		String msg="Product not available";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Product products = session.get(Product.class, productId);
			if(products!=null) {
				msg="Quantity is not avilable please come after some time";
				if(products.getAvailableQty()>=quantity) {
					products.setAvailableQty(products.getAvailableQty()-quantity);
					 msg="Product purchess successfully";
					 tx.commit();
					
				}
			}
			
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return msg;
		
	}
	
	
	public List<Product> getAllProducts() {
		String jpql = "select p from Product p";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql,Product.class).getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}


}
