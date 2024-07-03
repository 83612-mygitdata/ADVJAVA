package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.pojos.User;
import com.sunbem.daos.UserDao;
import com.sunbem.daos.UserDaoImpl;

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
		try(UserDao userDao = new UserDaoImpl()) {
			User user = userDao.findByEmail(email);
			if(user != null && user.getPassword().equals(passwd)) {
				
				Cookie c = new Cookie("uname", user.getFirstName());
				c.setMaxAge(3600); 
				resp.addCookie(c);
				
				HttpSession session = req.getSession();
				session.setAttribute("curuser", user);
				
				
				if(user.getRole().equals("voter")) { // voter login
					resp.sendRedirect("candList");
					
					//RequestDispatcher rd = req.getRequestDispatcher("candlist");
					//rd.forward(req, resp);
					
					
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
				
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("AppTitle");
				out.printf("<h3>%s</h3>", appTitle);

				
				out.println("Invaild email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
