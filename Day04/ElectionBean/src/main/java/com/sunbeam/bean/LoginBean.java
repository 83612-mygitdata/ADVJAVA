package com.sunbeam.bean;

import com.sunbeam.pojos.User;
import com.sunbem.daos.UserDao;
import com.sunbem.daos.UserDaoImpl;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	
	public LoginBean() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User user = userDao.findByEmail(email);
			if(user.getPassword().equals(password))
			{
				
				this.user=user;
			}
			else
				this.user=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 
}
