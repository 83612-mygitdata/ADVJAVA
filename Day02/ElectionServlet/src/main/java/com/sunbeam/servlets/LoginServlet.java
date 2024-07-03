package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends  HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req, resp);
	}
	
    protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		try(UserDao userDao = new UserDaoImpl()){
			User user = userDao.findByEmail(email);
			if(user != null && user.getPassword().equals(passwd)) {
				//System.out.println("Login Successful: "+user);
				if(user.getRole().equals("voter")) {
					resp.sendRedirect("candList");
					
				}
				else {
					resp.sendRedirect("result");
				}
			}
			
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invaild email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
