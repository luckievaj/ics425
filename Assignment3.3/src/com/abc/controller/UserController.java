package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.*;
import com.abc.model.*;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String CANCEL = "/index.jsp"; 
    private static String INSERT = "/user.jsp";
    private static String VIEW = "/userDetail.jsp";
    private static String EDIT = "/userEdit.jsp";
    private static String LIST_USER = "/viewAllUsers.jsp";
    private UserService dao;

    public UserController() {
        super();
        dao = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userid"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("userList", UserService.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            int userId = Integer.parseInt(request.getParameter("userid"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("userList", UserService.getAllUsers());
        } else if (action.equalsIgnoreCase("cancel")){
            forward = CANCEL;
        } else if (action.equalsIgnoreCase("view")){
        	forward = VIEW;
            int userId = Integer.parseInt(request.getParameter("userid"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        }else {
            forward = INSERT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	User user = new User();
        String userid = request.getParameter("userid");
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUserName(request.getParameter("userName"));
        
        //need null validation
        
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("userList", UserService.getAllUsers());
        view.forward(request, response);
        
    }
}