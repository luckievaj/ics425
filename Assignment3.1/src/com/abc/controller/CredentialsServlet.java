package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.*;
import com.abc.service.*;
import com.abc.service.CustomerService;
/**
 * Servlet implementation class CredentialsServlet
 */
@WebServlet("/CredentialsServlet")
public class CredentialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/index.jsp";
    private String previousPage = "/customerAddress.jsp";
    private String nextPage = "/customerConfirm.jsp";

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
                Credentials cred = (Credentials) request.getSession().getAttribute("credentials");            
                if (null == cred) {
                	cred = new Credentials();
                    request.getSession().setAttribute("credentials", cred);
                }
                cred.setAnnDate1(request.getParameter("annDate1"));
                cred.setAnnDesc1(request.getParameter("annDesc1"));
                cred.setAnnDate2(request.getParameter("annDate2"));
                cred.setAnnDesc2(request.getParameter("annDesc2"));
                cred.setAnnDate3(request.getParameter("annDate3"));
                cred.setAnnDesc3(request.getParameter("annDesc3"));
                
                String annDate1 = request.getParameter("annDate1");
                String annDesc1 = request.getParameter("annDesc1");
                String annDate2 = request.getParameter("annDate2");
                String annDesc2 = request.getParameter("annDesc2");               
                String annDate3 = request.getParameter("annDate3");
                String annDesc3 = request.getParameter("annDesc3");              
                
				Credentials credentials = new Credentials(annDate1, annDesc1, annDate2, annDesc2, annDate3, annDesc3);

				CredentialsService.persistCredentials(credentials);

				request.setAttribute("credentials", CustomerService.getAllCustomers());
                
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}

}
