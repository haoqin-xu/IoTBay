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
        CustomerManager manager = (CustomerManager) session.getAttribute("CustomerManager");
        //int customerid, string email, string name, string password, string dob, string phone, string address, string role
        
        Validator validator = new Validator();
        Customer customer = null;
        session.setAttribute("customer", null);
        session.setAttribute("statoedit", null);
        session.setAttribute("editResult", "");
        String custEmail = request.getParameter("custemail");
        String custPassword = request.getParameter("custpassword");
        if (request.getParameter("custEmail") != null) { 
            
            try {
                customer = manager.findUser(custEmail, custPassword);
                session.setAttribute("statoedit", customer); 
                session.setAttribute("editResult", "Editing customer user "+customer.getName()+" with ID "+customer.getID()+".");
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProfileController.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("editResult", "Error: Customer user not found");
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        } else {   
            int ID = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String role = request.getParameter("role");
        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("profile.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("profile.jsp").include(request, response);
        }
        else{
            try{
                manager.updateUser(ID, email, name, password, dob, phone, address, role);
            }
            catch(SQLException exception){
                Logger.getLogger(UpdateProfileController.class.getName()).log(Level.SEVERE, null, exception);
                session.setAttribute("editResult", "Error: Unable to update staff user details.");
            }
        }
    }
    request.getRequestDispatcher("profile.jsp").include(request, response);
    }
}
