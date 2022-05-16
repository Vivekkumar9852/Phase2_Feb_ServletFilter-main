package com.simplilearn.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="B", urlPatterns = {"/dashboard","/profile"})
public class LoginFilter  implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter code executed");
		
		String userId = request.getParameter("userId");
		
		if(userId!=null && userId.equalsIgnoreCase("johndoe")) {
			System.out.println("Before Executing Servlet - INSIDE FILTER");
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println("Block reuest");
		/*request.getRequestDispatcher("/block").forward(request, response);*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
