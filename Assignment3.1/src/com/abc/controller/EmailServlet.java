package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Email;
import com.abc.service.CustomerService;
/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String previousPage = "/customerPhone.jsp";
	private String nextPage = "/customerCredentials.jsp";

	public EmailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean next = (request.getParameter("next") != null);
		boolean previous = (request.getParameter("previous") != null);        
		boolean cancel = (request.getParameter("cancel") != null);
		String forwardedPage = 
				(next ? nextPage : (previous ? previousPage : cancelPage));
		if (cancel) {
			request.getSession().invalidate();
			forwardedPage = cancelPage;
		} else {
			synchronized(request.getSession() ) {
				Email email = (Email) request.getSession().getAttribute("eml");
				if (null == email) {
					email = new Email();
					request.getSession().setAttribute("eml", email);
				}

				if ("".equalsIgnoreCase(request.getParameter("email1")) 
						|| "".equalsIgnoreCase(request.getParameter("email2"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					email.setEmail1((String)request.getParameter("email1"));
					email.setEmail2((String)request.getParameter("email2"));

					CustomerService.persistEmail(email);
				}        
			}
			getServletContext().getRequestDispatcher(forwardedPage).
			forward(request, response);

		}
	}
}
