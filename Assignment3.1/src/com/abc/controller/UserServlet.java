package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
//	private String cancelPage = "/index.jsp";
//	private String createPage = "/userConfirm.jsp";

	public UserServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	//Controller is tightly coupled to model and view
		
		//Step 1. Retrieve request parameters
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		
		//Step 1a.Declarative lookup. Perform validation
		
		//Step 1b. Set up the model components
		
		User user = new User(firstName, lastName, userName);
		
		//Step 2. Declarative lookup. Invoke request processing component to Deal with the Model
		UserService.persistUser(user);
		
		//Step 2a. Setup model for use by JSP
		request.setAttribute("user", UserService.getAllUsers());
		
		//Step 3. Declarative lookup. Determine the View and Dispatch to it.
		RequestDispatcher dispatcher =
	 		getServletContext().getRequestDispatcher("/userConfirm.jsp");
		dispatcher.forward(request,  response);
	}
}