package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;

@WebServlet("/ContactNameServlet")
public class ContactNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String cancelPage = "/index.jsp";
    private String nextPage = "/address.jsp";
    
    public ContactNameServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean next = (request.getParameter("next") != null);
		boolean cancel = (request.getParameter("cancel") != null);
		String forwardedPage = (next ? nextPage : (cancelPage));
		if (cancel) {
			request.getSession().invalidate();
			forwardedPage = cancelPage;
		} else {
			synchronized (request.getSession()) {
				ContactName contactName = (ContactName) request.getSession().getAttribute("contactName");
				if (null == contactName) {
					contactName = new ContactName();
					request.getSession().setAttribute("contactName", contactName);
				}
				if ("".equalsIgnoreCase(request.getParameter("firstName"))
						|| "".equalsIgnoreCase(request.getParameter("lastName"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					contactName.setFirstName(request.getParameter("firstName"));
					contactName.setLastName(request.getParameter("lastName"));
				}
			}
			getServletContext().getRequestDispatcher(forwardedPage).forward(
					request, response);
		}
	}
}
