package com.sunbeam.tester;

import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;

public class GetProductDetails {
	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductDao Dao = new ProductDaoImpl();
			System.out.println("Enter product id : ");
			System.out.println(Dao.getProductDetailsById(sc.nextLong()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
