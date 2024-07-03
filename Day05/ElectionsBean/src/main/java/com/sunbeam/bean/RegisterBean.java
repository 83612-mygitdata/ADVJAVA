package com.sunbeam.bean;

import java.sql.Date;

import com.sunbeam.pojos.User;
import com.sunbem.daos.UserDao;
import com.sunbem.daos.UserDaoImpl;

public class RegisterBean {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private String role;
	private int status;
	private int count;
	
	
	public RegisterBean() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	public void registerUser() {
				Date dob = Date.valueOf(birth);
				User u = new User(0, firstName, lastName, email, password, dob, status, role);
				try(UserDao userDao = new UserDaoImpl()) {
					count = userDao.save(u);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	
	
	
}
