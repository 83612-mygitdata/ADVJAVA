package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class DeleteProduct {
	
	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product name for deleting the product : ");
			System.out.println(dao.deleteProduct(sc.next()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
