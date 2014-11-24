package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abc.model.Credentials;
/**
 * Servlet implementation class CredentialsServlet
 */
@WebServlet("/CredentialsServlet")
public class CredentialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cancelPage = "/name.jsp";
    private String previousPage = "/address.jsp";
    private String nextPage = "/confirm.jsp";

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
                credentials.setUsername(request.getParameter("username"));
                credentials.setPassword(request.getParameter("password"));
                
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}

}
