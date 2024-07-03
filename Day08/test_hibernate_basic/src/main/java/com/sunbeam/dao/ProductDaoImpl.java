package com.sunbeam.dao;

import com.sunbeam.entites.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

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

}
