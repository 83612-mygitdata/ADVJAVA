package com.sunbeam.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	
	static {
		factory = new Configuration()
				  .configure()
				  .buildSessionFactory();//it will be created only once
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}

}
