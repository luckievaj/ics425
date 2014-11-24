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
    private String nextPage = "/userConfirm.jsp"; // POINT TO SHOW ALL USERS AFTER DONE
    
    public NameServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            Name name = (Name) request.getSession().getAttribute("name");
            if (null == name) {
                name = new Name();
                request.getSession().setAttribute("name", name);
            }
            if ("".equalsIgnoreCase(request.getParameter("firstName")) 
                    || "".equalsIgnoreCase(request.getParameter("lastName"))
                    || "".equalsIgnoreCase(request.getParameter("userName"))) {
                request.setAttribute("message", "Please enter all fields!");
                forwardedPage = cancelPage;
            } else {
                name.setFirstName(request.getParameter("firstName"));
                name.setLastName(request.getParameter("lastName"));
                name.setUserName(request.getParameter("userName"));
            }            
        }        
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}
	}}
