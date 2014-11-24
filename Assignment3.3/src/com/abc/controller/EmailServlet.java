package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;
/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String cancelPage = "/index.jsp";
    private String previousPage = "/phone.jsp";
    private String nextPage = "/credentials.jsp";
    
    public EmailServlet() {
        super();
       
    }

	
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
                Email email = (Email) request.getSession().getAttribute("email");            
                if (null == email) {
                    email = new Email();
                    request.getSession().setAttribute("email", email);
                }    
                email.setEmail1(request.getParameter("email1"));
                email.setEmail2(request.getParameter("email2"));
                                          
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}

}
