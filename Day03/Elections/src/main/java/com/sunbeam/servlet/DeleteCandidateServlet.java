package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbem.daos.CandidateDao;
import com.sunbem.daos.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.deleteById(id);
			String msg = "Candidates deleted: " + count;
			req.setAttribute("message", msg);
			//RequestDispatcher rd = req.getRequestDispatcher("result");
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/result");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
