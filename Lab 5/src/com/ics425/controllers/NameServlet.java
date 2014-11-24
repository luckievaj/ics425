package com.ics425.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ics425.model.Person;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String cancelPage = "/name.jsp";
    private String nextPage = "/address.jsp";
    public NameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        String forwardedPage = nextPage;
        synchronized(request.getSession() ) {
            Person person = (Person) request.getSession().getAttribute("person");
            if (null == person) {
                person = new Person();
                request.getSession().setAttribute("person", person);
            }
            
            if ("".equalsIgnoreCase(request.getParameter("firstName")) 
                    || "".equalsIgnoreCase(request.getParameter("lastName"))) {
                request.setAttribute("message", "Please enter all fields!");
                forwardedPage = cancelPage;
            } else {
                person.setFirstName(request.getParameter("firstName"));
                person.setLastName(request.getParameter("lastName"));
            }            
        }        
        getServletContext().getRequestDispatcher(forwardedPage).
          forward(request, response);
    }
}

