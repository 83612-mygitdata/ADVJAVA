package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;
import com.sunbeam.entities.Category;


public class GetProductByPriceAndCat
{
	public static void main(String[] args)
	{
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			// create dao instance
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter minimum and maximum price and category:");
			dao.getProductsByPrAndCat(sc.nextDouble(), sc.nextDouble(),
					Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}

