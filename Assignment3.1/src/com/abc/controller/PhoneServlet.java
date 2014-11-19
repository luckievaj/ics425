package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Phone;
import com.abc.service.CustomerService;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/PhoneServlet")
public class PhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String previousPage = "/customerAddress.jsp";
	private String nextPage = "/customerEmail.jsp";

	public PhoneServlet() {
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
				Phone phone = (Phone) request.getSession().getAttribute("phn");            
				if (null == phone) {
					phone = new Phone();
					request.getSession().setAttribute("phn", phone);
				}    
				phone.setPhone1((String)request.getParameter("phone1"));
				phone.setPhone2((String)request.getParameter("phone2"));

				CustomerService.persistPhone(phone);
			}        
		}
		getServletContext().getRequestDispatcher(forwardedPage).
		forward(request, response);

	}

}
