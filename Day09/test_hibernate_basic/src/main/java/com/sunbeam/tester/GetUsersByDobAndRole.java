package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entites.Category;


public class GetUsersByDobAndRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter begin end Price and Category : ");
			dao.getProductByPriceAndCategory(sc.nextDouble(), sc.nextDouble(), Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
