package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Customer;
/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String nextPage = "/createAddress.jsp";

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
				
//need to figure out where "Person" is defined and what to change it to
				
				Customer cust = (Customer) request.getSession().getAttribute("cust");
				if (null == cust) {
					cust = new Customer();
					request.getSession().setAttribute("cust", cust);
				}

				if ("".equalsIgnoreCase(request.getParameter("firstName")) 
						|| "".equalsIgnoreCase(request.getParameter("lastName"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					cust.setFirstName(request.getParameter("firstName"));
					cust.setLastName(request.getParameter("lastName"));
				}            
			}        
			getServletContext().getRequestDispatcher(forwardedPage).
			forward(request, response);

		}
	}
}
