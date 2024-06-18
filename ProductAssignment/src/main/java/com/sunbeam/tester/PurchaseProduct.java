package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class PurchaseProduct {
	
	public static void main(String[] args)
	{
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter the id of the product : and quqntity : ");
			System.out.println(dao.purchaseProduct(sc.nextLong(), sc.nextInt()));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
