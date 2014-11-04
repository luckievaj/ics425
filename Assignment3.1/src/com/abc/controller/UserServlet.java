package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.User;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String createPage = "/userConfirm.jsp";

	public UserServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean next = (request.getParameter("create") != null);
		boolean cancel = (request.getParameter("cancel") != null);
		String forwardedPage = 
				(next ? createPage : (cancelPage));
		if (cancel) {
			request.getSession().invalidate();
			forwardedPage = cancelPage;
		} else {
			synchronized(request.getSession() ) {
				User usr = (User) request.getSession().getAttribute("usr");
				if (null == usr) {
					usr = new User();
					request.getSession().setAttribute("usr", usr);
				}

				if ("".equalsIgnoreCase(request.getParameter("firstName")) 
						|| "".equalsIgnoreCase(request.getParameter("lastName"))
						|| "".equalsIgnoreCase(request.getParameter("userName"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = cancelPage;
				} else {
					usr.setFirstName(request.getParameter("firstName"));
					usr.setLastName(request.getParameter("lastName"));
					usr.setUserName(request.getParameter("userName"));
				}            
			}        
			getServletContext().getRequestDispatcher(forwardedPage).
			forward(request, response);

		}
	}
}
