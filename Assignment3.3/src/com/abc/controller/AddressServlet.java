package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;
/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
    private String previousPage = "/name.jsp";
    private String nextPage = "/phone.jsp";
    
    public AddressServlet() {
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
                Phone address = (Phone) request.getSession().getAttribute("address");            
                if (null == address) {
                    address = new Phone();
                    request.getSession().setAttribute("address", address);
                }    
                address.setStreet(request.getParameter("street"));
                address.setCity(request.getParameter("city"));
                address.setState(request.getParameter("state"));
                address.setZipCode(request.getParameter("zipCode"));
               
                
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}


	}


