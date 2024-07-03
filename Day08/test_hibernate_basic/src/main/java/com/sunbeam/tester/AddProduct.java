package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entites.*;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;


public class AddProduct {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter products details - category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique),price , available quantity");
			Product newproduct = new Product(Category.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextDouble(),sc.nextInt());
			System.out.println(dao.AddProduct(newproduct));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
