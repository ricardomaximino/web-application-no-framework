package com.brasajava.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brasajava.daos.ContactDao;

/**
 * Servlet implementation class MySecondServlet
 */
@WebServlet(urlPatterns="/second/*",name="A")
public class MySecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MySecondServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initiating My Second Servlet");
	}

	public void destroy() {
		System.out.println("Destroying Second Servlet");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("Action = " + action + " in My Second Servlet");
		request.setAttribute("contactDao", new ContactDao());
		if (action.equals("contact")) {
			request.getRequestDispatcher("/home2.xhtml").forward(request, response);
			return;
		} if (action.equals("hide")) {
			request.getRequestDispatcher("/WEB-INF/view/hide.xhtml").forward(request, response);
			return;
		}else {
			request.getRequestDispatcher("/404.xhtml").forward(request, response);
		}
	}

}
