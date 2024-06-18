package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class ApplyDiscount {
	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in))
		{
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter discount amount and category : ");
			System.out.println(dao.applyDiscount(sc.nextDouble(), Category.valueOf(sc.next().toUpperCase())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
