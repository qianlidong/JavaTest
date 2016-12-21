package com.qian.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/MyFilter")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		 fc = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  HttpServletResponse httpservletresponse = (HttpServletResponse)response;
		  HttpServletRequest hrequest = (HttpServletRequest) request;
	        String s = "";
	        for(Enumeration enumeration = fc.getInitParameterNames(); enumeration.hasMoreElements(); httpservletresponse.addHeader(s, fc.getInitParameter(s))){
	            s = (String)enumeration.nextElement();
	           
	        }
	 String code= hrequest.getServletPath();
	 System.err.println("参数有哪些:"+code);
//	 if(code.indexOf("qian")==-1){
//		 System.out.println("你请求的地址不合法");
//		 response.getWriter().write("你请求的地址不合法!马上跳回主页");
//		 httpservletresponse.sendRedirect("index.jsp"); 
//		 return ;
//	 }
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 fc = fConfig;
	}


    FilterConfig fc;
}
