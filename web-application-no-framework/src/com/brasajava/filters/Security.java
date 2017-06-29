package com.brasajava.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Security
 */
@WebFilter(urlPatterns="/*",filterName="B")
public class Security implements Filter {

	private FilterConfig fConfig;
    /**
     * Default constructor. 
     */
    public Security() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Destroying Security Filter " + fConfig.getFilterName());
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(fConfig.getFilterName() + " before dofilter");
		chain.doFilter(request, response);
		System.out.println(fConfig.getFilterName()+ " after dofilter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		System.out.println("Initiating Security Filter " + fConfig.getFilterName());
	}

}
