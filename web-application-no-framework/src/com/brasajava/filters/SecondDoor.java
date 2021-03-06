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
 * Servlet Filter implementation class SecondDoor
 */
@WebFilter(urlPatterns="/*",filterName="A")
public class SecondDoor implements Filter {
	private FilterConfig fConfig;

    /**
     * Default constructor. 
     */
    public SecondDoor() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Destroying Second Door Filter " );
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(fConfig.getFilterName() + " before dofilter");
		chain.doFilter(request, response);
		System.out.println(fConfig.getFilterName() + " after dofilter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		System.out.println("Initiating Second Door Filter " + fConfig.getFilterName());
	}

}
