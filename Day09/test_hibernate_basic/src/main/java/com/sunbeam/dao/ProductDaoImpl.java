package com.sunbeam.dao;

import com.sunbeam.entites.Category;
import com.sunbeam.entites.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String AddProduct(Product product) {
		String msg = "Failed to Add Product";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			Serializable userId = session.save(product);
			tx.commit();
			msg="successfully Added a Product";
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	
	public Product getProductById(Long productId) {
		Product product = null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			product=session.get(Product.class,productId);
			product=session.get(Product.class,productId);
			product=session.get(Product.class,productId);
			product=session.get(Product.class,productId);
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
		
	}


	@Override
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


	@Override
	public List<Product> getProductByPriceAndCategory(double start, double end, Category userCategory) {
		String jpql = "select p from Product p where p.price between :start and :end and p.category=:ct";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql,Product.class)
					.setParameter("start", start)
					.setParameter("end", end)
					.setParameter("ct", userCategory)
					.getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}


	@Override
	public String applyDiscount(Category userCategory, double discount) {
		String mesg = "applying discount failed !!!!";
		String jpql = "update Product p set p.price=p.price-:disc where p.category=:ct";
		    Session session = getFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				int rows = session.createQuery(jpql)
						.setParameter("disc", discount)
						.setParameter("ct", userCategory)
						.executeUpdate();
				tx.commit();
				mesg = "Applied discount to users - " + rows;
			}catch (RuntimeException e) {
				if(tx != null)
					tx.rollback();
				throw e;
			}
		return mesg;
	}


	@Override
	public String PurchaseProduct(Long productId, int quantity) {
		String msg="Product not available";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Product products = session.get(Product.class, productId);
			if(products!=null) {
				msg="Quantity is not avilable please come after some time";
				if(products.getAva_quantity()>=quantity) {
					products.setAva_quantity(products.getAva_quantity()-quantity);
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


	@Override
	public String deleteProductDetails(String productName) {
		String jpql = "select p from Product p where p.product_name=:nm";
		String msg="Please enter valic product name";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			Product product = session.createQuery(jpql,Product.class)
					        .setParameter("nm", productName)
					        .getSingleResult();
			if (product != null) {
				
				session.delete(product);
				msg = "Product details deleted successfully...";
			}
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}
}
