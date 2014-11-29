package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.*;
import com.abc.model.*;



public class ContactController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String CANCEL = "/index.jsp"; 
    private static String INSERT = "/contactName.jsp";
    private static String VIEW = "/contactDetail.jsp";
    private static String EDIT = "/contactEdit.jsp";
    private static String LIST_CONTACT = "/viewAllUsers.jsp";
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
            forward = LIST_CONTACT;
            request.setAttribute("contactList", ContactService.getAllContacts());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            int contactId = Integer.parseInt(request.getParameter("contactId"));
            Contact contact = dao.getContactById(contactId);
            request.setAttribute("contact", contact);
        } else if (action.equalsIgnoreCase("listContacts")){
            forward = LIST_CONTACT;
            request.setAttribute("contactList", ContactService.getAllContacts());
        } else if (action.equalsIgnoreCase("cancel")){
            forward = CANCEL;
        } else if (action.equalsIgnoreCase("view")){
        	forward = VIEW;
            int contactId = Integer.parseInt(request.getParameter("contactId"));
            Contact contact = dao.getContactById(contactId);
            request.setAttribute("contact", contact);
        } else {
            forward = INSERT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactName name = new ContactName();
        Address address = new Address();
        Phone phone = new Phone();
        Email email = new Email();
        Credentials credentials = new Credentials();

        String contactId = request.getParameter("contactId");
        name.setFirstName(request.getParameter("firstName"));
        name.setLastName(request.getParameter("lastName"));
        address.setStreet(request.getParameter("street"));
        address.setCity(request.getParameter("city"));
        address.setState(request.getParameter("state"));
        address.setZipCode(request.getParameter("zipCode"));
		credentials.setAnnDate1(request.getParameter("annDate1"));
		credentials.setAnnDate1(request.getParameter("annDesc1"));
		credentials.setAnnDate2(request.getParameter("annDate2"));
		credentials.setAnnDate2(request.getParameter("annDesc2"));
		credentials.setAnnDate3(request.getParameter("annDate3"));
		credentials.setAnnDate3(request.getParameter("annDesc3"));
		phone.setPhone1(request.getParameter("phone1"));
		phone.setPhone2(request.getParameter("phone2"));
		email.setEmail1(request.getParameter("email1"));
		email.setEmail2(request.getParameter("email2"));
        
        if(contactId == null || contactId.isEmpty())
        {
            dao.addContact(name);
            dao.addAddress(address);
            dao.addPhone(phone);
            dao.addEmail(email);
            dao.addCredentials(credentials);
        }
        else
        {
            name.setContactId(Integer.parseInt(contactId));
            dao.updateContact(name);
            dao.updateAddress(address);
            dao.updatePhone(phone);
            dao.updateEmail(email);
            dao.updateCredentials(credentials);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CONTACT);
        request.setAttribute("contactList", ContactService.getAllContacts());
        view.forward(request, response);
    }
}