package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;


/**
 * Servlet implementation class CredentialsServlet
 */
@WebServlet("/CredentialsServlet")
public class CredentialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
    private String previousPage = "/email.jsp";
    private String nextPage = "/contactConfirm.jsp";

    public CredentialsServlet() {
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
                Credentials credentials = (Credentials) request.getSession().getAttribute("credentials");            
                if (null == credentials) {
                	credentials = new Credentials();
                    request.getSession().setAttribute("credentials", credentials);
                }
                credentials.setAnnDate1(request.getParameter("annDate1"));
                credentials.setAnnDesc1(request.getParameter("annDesc1"));
                credentials.setAnnDate2(request.getParameter("annDate2"));
                credentials.setAnnDesc2(request.getParameter("annDesc2"));
                credentials.setAnnDate3(request.getParameter("annDate3"));
                credentials.setAnnDesc3(request.getParameter("annDesc3"));
                
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}

}
