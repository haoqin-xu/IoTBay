/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.Customer;

import uts.isd.model.dao.CustomerManager;

import java.io.IOException;

import java.sql.SQLException;    

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 *
 * @author 61452
 */
public class UpdateProfileController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve the current session
        HttpSession session = request.getSession();
        CustomerManager manager = (CustomerManager) session.getAttribute("manager");
        //int customerid, string email, string name, string password, string dob, string phone, string address, string role
        int customerID = Integer.parseInt(request.getParameter("customerid"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        
        Validator validator = new Validator();
        validator.clear(session);
        if (!validator.validateEmail(email)) {
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the Profile.jsp
            request.getRequestDispatcher("profile.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the Profile.jsp
            request.getRequestDispatcher("profile.jsp").include(request, response);
        }
        try{
            manager.updateUser(customerID, email, name, password, dob, phone, address, role);
        }
        catch(SQLException exception){
            Logger.getLogger(UpdateProfileController.class.getName()).log(Level.SEVERE, null, exception);
        }
        request.getRequestDispatcher("profile.jsp").include(request, response);
    }
}
