package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Pojos.User;
import daos.CandidateDao;
import daos.CandidateDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;

public class VoteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException 
	{
		System.out.println("pre");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("curuser");
		int userId = user.getId();
		System.out.println(userId);
		String message = "";
		
		if(user.getStatus()==0)
		{
			String candidateId = req.getParameter("candidate");
			int id = Integer.parseInt(candidateId);
			try(CandidateDao candiDao = new CandidateDaoImpl())
			{
				candiDao.incrementVote(id);
			} 
			catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			message = "Your vote is registered successfully!";
			
			try(UserDao userDao = new UserDaoImpl())
			{
				userDao.updateStatus(userId, true);
			} 
			catch (Exception e) {
				
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else
		{
			message = "You have already voted!";
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted!</title>");
		out.println("<body>");
		//out.println("<h3>Online Voting!</h3>");
		ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("AppTitle");
				out.printf("<h3>%s</h3>", appTitle);
		String username = "";
		Cookie[] arr = req.getCookies();
		if(arr != null)
		{
			for(Cookie c:arr)
			{
				if(c.getName().equals("uname"))
				{
					username = c.getValue();
				}
			}
				
		}
		out.printf("Hello %s<hr/>/n",username);
		out.println(message);
		out.println("<a href='logout'>Sign out</a>");
		out.println("</body>");
		out.println("</html>");
	}
	

}
