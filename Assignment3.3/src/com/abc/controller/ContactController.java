package com.abc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.ContactService;
import com.abc.model.*;



public class ContactController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/contact.jsp";
    private static String LIST_USER = "/addresss.jsp";
    private ContactService dao;

    public ContactController() {
        super();
        dao = new ContactService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int contactId = Integer.parseInt(request.getParameter("contactId"));
            dao.deleteContact(contactId);
            forward = LIST_USER;
            request.setAttribute("contacts", dao.getAllContacts());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int contactId = Integer.parseInt(request.getParameter("contactId"));
            ContactName contact = dao.getContactById(contactId);
            request.setAttribute("contact", contact);
        } else if (action.equalsIgnoreCase("listContactName")){
            forward = LIST_USER;
            request.setAttribute("contacts", dao.getAllContacts());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactName contact = new ContactName();
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        String contactid = request.getParameter("contactid");
        if(contactid == null || contactid.isEmpty())
        {
            dao.addContact(contact);
        }
        else
        {
            contact.setContactId(Integer.parseInt(contactid));
            dao.updateContact(contact);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("contacts", dao.getAllContacts());
        view.forward(request, response);
    }
}