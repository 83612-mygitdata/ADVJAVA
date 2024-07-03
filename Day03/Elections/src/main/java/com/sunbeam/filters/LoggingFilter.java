package com.sunbeam.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter({"/login", "/candlist", "/vote", "/logout"})
@WebFilter("/*")
public class LoggingFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("LoggingFilter.init() called.");
	}
	
	@Override
	public void destroy() {
		System.out.println("LoggingFilter.destroy() called.");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) req;
		System.out.println("Log BEFORE: " + rq.getRequestURI());
		chain.doFilter(req, resp);
		System.out.println("Log AFTER: " + rq.getRequestURI());		
	}
}