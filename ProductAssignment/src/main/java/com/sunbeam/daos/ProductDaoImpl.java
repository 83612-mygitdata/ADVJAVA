package com.sunbeam.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;


public class ProductDaoImpl implements ProductDao{

	@Override
	public String addProduct(Products product) {
		String msg = "Product couldn't be added!";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable id = session.save(product);
			tx.commit();
			msg = "Product added successfully with id "+id;
		} catch(RuntimeException e)
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public Products getProductDetailsById(long id) {
		Products product=null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product=session.get(Products.class, id);//select
			product=session.get(Products.class, id);
			product=session.get(Products.class, id);
			product=session.get(Products.class, id);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
			{
				tx.rollback();
				
			}
			throw e;
		}
		return product;
	}

	@Override
	public List<Products> getProductsByPrAndCat(double min, double max, Category category) {
		String jpql = "select p from Products p where p.price between :min1 and :max1 and p.category=:cat";
		List<Products> products = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			products = session.createQuery(jpql,Products.class)
					.setParameter("min1", min).setParameter("max1",max).setParameter("cat", category)
					.getResultList();
			tx.commit();
		}
		catch(RuntimeException e){
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		return products;
	}

	@Override
	public String applyDiscount(double discount, Category category) {
		String msg = "Applying discount failed!!";
		String jpql = "update Products p set p.price = p.price-:disc where p.category=:cat";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("cat", category)
					.executeUpdate();
			tx.commit();
			msg = "Discount applied to "+rows+" products";
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String purchaseProduct(Long id, int quantity) {
		
		//System.out.println("Enter the quantity required:");
		
		String msg = "Product is not available!";
		//String jpql = "select p from Products p where "
		Session session=getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Products product = session.get(Products.class, id);
			if(product != null)
			{
//				int demand;
//				System.out.println("Enter the quantity of products you want to purchase : ");
//				Scanner sc = new Scanner(System.in);
//				quantity = sc.nextInt();
				if(quantity>product.getQuantity())
				{
					System.out.println("Product is not available!");
				}
				else
				{
					product.setQuantity(product.getQuantity()-quantity);
					msg = "Product purchased successfully!";
					tx.commit();
				}
			}
				
				
				
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteProduct(String name) {
		String msg = "Product couldn't be deleted!";
		String jpql = "select p from Products p where p.name=:nm";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Products product = session.createQuery(jpql,Products.class)
					.setParameter("nm", name).getSingleResult();
			if(product!=null)
				session.delete(product);
			tx.commit();
			msg="Product deleted successfully!";
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	

}
