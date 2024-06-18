package com.sunbeam.tester;


import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public class AddProduct {
	
	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Product details :Category category, String name, double price, int quantity");
			Products newProduct = new Products(Category.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextDouble(),sc.nextInt());
			
			System.out.println(dao.addProduct(newProduct));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
