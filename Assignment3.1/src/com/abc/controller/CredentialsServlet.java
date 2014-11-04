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
	private String cancelPage = "/index.jsp";
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
                credentials.setAnn_Date1(request.getParameter("ann_date1"));
                credentials.setAnn_Desc1(request.getParameter("ann_desc1"));
                credentials.setAnn_Date2(request.getParameter("ann_date2"));
                credentials.setAnn_Desc2(request.getParameter("ann_desc2"));
                credentials.setAnn_Date3(request.getParameter("ann_date3"));
                credentials.setAnn_Desc3(request.getParameter("ann_desc3"));
            }        
        }
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);

	}

}
