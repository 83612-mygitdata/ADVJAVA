package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import static com.sunbeam.utils.HibernateUtils.getFactory;

public class GetAllUsers {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory()){
			ProductDao dao = new ProductDaoImpl();
			dao.getAllProducts().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
