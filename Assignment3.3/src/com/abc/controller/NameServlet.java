package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;
/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String cancelPage = "/index.jsp";
    private String nextPage = "/userConfirm.jsp"; 
    
    public NameServlet() {
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
				ContactName cName = (ContactName) request.getSession().getAttribute("cName");
				if (null == cName) {
					cName = new ContactName();
					request.getSession().setAttribute("cName", cName);
				}
				if ("".equalsIgnoreCase(request.getParameter("firstName"))
						|| "".equalsIgnoreCase(request.getParameter("lastName"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					cName.setFirstName(request.getParameter("firstName"));
					cName.setLastName(request.getParameter("lastName"));
			
				}
			}
			getServletContext().getRequestDispatcher(forwardedPage).forward(
					request, response);

		}
	}
}
