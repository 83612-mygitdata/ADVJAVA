package bean;

import Pojos.User;
import daos.UserDao;
import daos.UserDaoImpl;

public class loginbean {
	private String email;
	private String passwd;
	private User user;
	
	public loginbean() {
	}

	public loginbean(String email, String passwd, User user) {
		this.email = email;
		this.passwd = passwd;
		this.user = user;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate()
	{
		try(UserDao userDao = new UserDaoImpl())
		{
			User u = userDao.findByEmail(email);
			if(u!=null && u.getPassword().equals(passwd))
			{
				this.user = u;
			}
			else
			{
				this.user = null;
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
