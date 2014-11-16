package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.User;
import com.abc.service.UserService;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
	private String nextPage = "/userConfirm.jsp";

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardedPage = nextPage;
		synchronized(request.getSession() ) {
			User user = (User) request.getSession().getAttribute("user");
			if (null == user) {
				user = new User();
				request.getSession().setAttribute("user", user);
			}

			if ("".equalsIgnoreCase(request.getParameter("firstName")) 
					|| "".equalsIgnoreCase(request.getParameter("lastName"))
					|| "".equalsIgnoreCase(request.getParameter("userName"))) {
				request.setAttribute("message", "Please enter all fields!");
				forwardedPage = cancelPage;
			} else {
				user.setFirstName(request.getParameter("firstName"));
				user.setLastName(request.getParameter("lastName"));
				user.setUserName(request.getParameter("userName"));

				//Method to pass collected information to the Service to write to the DB.
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String userName = request.getParameter("userName");

				user = new User(firstName, lastName, userName);

				UserService.persistUser(user);

				request.setAttribute("usr", UserService.getAllUsers());
			}

			getServletContext().getRequestDispatcher(forwardedPage).
			forward(request, response);

		}
	}
}