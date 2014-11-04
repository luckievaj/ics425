package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.User;
/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String nextPage = "/address.jsp";

	public CustomerServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean next = (request.getParameter("next") != null);
		boolean cancel = (request.getParameter("cancel") != null);
		String forwardedPage = 
				(next ? nextPage : (cancelPage));
		if (cancel) {
			request.getSession().invalidate();
			forwardedPage = cancelPage;
		} else {
			synchronized(request.getSession() ) {
				User person = (User) request.getSession().getAttribute("person");
				if (null == person) {
					person = new User();
					request.getSession().setAttribute("person", person);
				}

				if ("".equalsIgnoreCase(request.getParameter("firstName")) 
						|| "".equalsIgnoreCase(request.getParameter("lastName"))
						|| "".equalsIgnoreCase(request.getParameter("userPassword"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					person.setFirstName(request.getParameter("firstName"));
					person.setLastName(request.getParameter("lastName"));
					person.setUserPassword(request.getParameter("userPassword"));
				}            
			}        
			getServletContext().getRequestDispatcher(forwardedPage).
			forward(request, response);

		}
	}
}
