package com.manage.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	private String exceptUri;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.exceptUri = filterConfig.getInitParameter("exceptUri");
		
		System.out.println("FilterName\n"+filterConfig.getFilterName());
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	    HttpServletRequest request = (HttpServletRequest)arg0;
	    HttpServletResponse response = (HttpServletResponse)arg1;
		System.err.println("URL ===> "+request.getRequestURL()+"?"+request.getQueryString());
//		System.err.println("URI ===> "+request.getRequestURI());
//		System.out.println(request.getRequestURI().toString());
//		response.sendRedirect(request.getRequestURI().toString());
		chain.doFilter(arg0, arg1);
		
        return;
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
