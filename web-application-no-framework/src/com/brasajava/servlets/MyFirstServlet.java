package com.brasajava.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String servletCreator;
	
	@Override
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.servletCreator = config.getInitParameter("servletCreator");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<body>");
        out.println("My very first servlet <br><hr/>");
        out.println("The servlet creator: " + servletCreator + "<br><hr/>"); 
        out.println("Variable by uri parameter name: param and value: " + request.getParameter("param") + "<br><hr/>");
        out.println("name: " + request.getParameter("name") + "<br>");
        out.println("e-mail: " + request.getParameter("email") + "<br>");
        out.println("address: " + request.getParameter("address") + "<br>");
        out.println("birthday: " + request.getParameter("birthday") + "<br><hr/>");
        out.println("</body>");
        out.println("</html>");
    
	}

}
