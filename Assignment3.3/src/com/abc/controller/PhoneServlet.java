package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;
/**
 * Servlet implementation class PhoneServlet
 */
@WebServlet("/PhoneServlet")
public class PhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
    private String previousPage = "/address.jsp";
    private String nextPage = "/email.jsp";
    public PhoneServlet() {
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
                Phone phone = (Phone) request.getSession().getAttribute("phone");            
                if (null == phone) {
                    phone = new Phone();
                    request.getSession().setAttribute("phone", phone);
                } if ("".equalsIgnoreCase(request.getParameter("phone1"))
						|| "".equalsIgnoreCase(request.getParameter("phone2"))) {
					request.setAttribute("message", "Please enter all fields!");
					forwardedPage = "/phone.jsp";
				} else {    
                phone.setPhone1(request.getParameter("phone1"));
                phone.setPhone2(request.getParameter("phone2"));
				}        
            }
            getServletContext().getRequestDispatcher(forwardedPage).
            forward(request, response);
        }
	}
}
