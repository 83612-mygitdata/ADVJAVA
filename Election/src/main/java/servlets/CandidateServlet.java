package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojos.Candidate;
import daos.CandidateDao;
import daos.CandidateDaoImpl;

//@WebServlet("/candidate")
public class CandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			list = candDao.findAll();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidates</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("<h2>Online Voting!</h2>");
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
		out.printf("Hello %s<hr/>",username);
		
		ServletContext ctx = this.getServletContext();
		String message = (String) ctx.getAttribute("announcement");
		if(message != null)
				out.printf("Announcement: %s<br/><br/>\n", message);
		out.println("<form method='post' action='vote'>");
		for(Candidate c:list)
			out.printf("<input type='radio' name='candidate' value='%d' />%s %s <br/>",
					c.getId(),c.getName(),c.getParty());
		out.println("<input type='submit' value='Vote'");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
			
			
	}
	
}
