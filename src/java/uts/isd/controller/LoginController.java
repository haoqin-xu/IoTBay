/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.*;

import uts.isd.model.dao.*;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //3- capture the posted email
        String email = request.getParameter("email");
        //4- capture the posted password
        String password = request.getParameter("password");
        // obtain type of user that is logging in
        String usertype = request.getParameter("usertype");
        //5- retrieve all 3 manager instances from session (there could be 3 types of users)
        CustomerManager manager = (CustomerManager) session.getAttribute("manager");
        StaffManager staffManager = (StaffManager) session.getAttribute("staffmanager");
        AdminManager adminManager = (AdminManager) session.getAttribute("adminmanager");

        validator.clear(session); //clears previous error mesages

        Customer customerUser = null;
        Staff staffUser = null;
        Admin adminUser = null;
           
        if (!validator.validateEmail(email)) {
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp
            request.getRequestDispatcher("login.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp
            request.getRequestDispatcher("login.jsp").include(request, response);

        } else {
            try {
                switch (usertype) { // what is the type of user logging in?
                    
                    case "customer":
                        //6- find customer by email and password
                        customerUser = manager.findUser(email, password);
                        if (customerUser != null) { // a user was found
                            session.setAttribute("user", customerUser);
                            session.setAttribute("usertype", "customer"); // set the type, it will be used when later accessing the user obj from session, so we know what to cast it as
                            //13-save the logged in user object to the session
                            request.getRequestDispatcher("index.jsp").include(request, response);
                            //14- redirect user to the main.jsp
                        } else {
                            //15-set user does not exist error to the session
                            session.setAttribute("existErr", "Error: User does not exist");
                            //16- redirect user back to the login.jsp
                            request.getRequestDispatcher("login.jsp").include(request, response);
                        }
                        break;
                        
                    case "staff":
                        //6- find staff by email and password
                        staffUser = staffManager.findUser(email, password);
                        if (staffUser != null) {
                            session.setAttribute("user", staffUser);
                            session.setAttribute("usertype", "staff"); // set the type, it will be used when later accessing the user obj from session, so we know what to cast it as
                            //13-save the logged in staff object to the session
                            request.getRequestDispatcher("main.jsp").include(request, response);
                            //14- redirect user to the main.jsp
                        } else {
                            //15-set user does not exist error to the session
                            session.setAttribute("existErr", "Error: User does not exist");
                            //16- redirect user back to the login.jsp
                            request.getRequestDispatcher("login.jsp").include(request, response);
                        }
                        break;
                        
                    case "admin":
                        //6- find user by email and password
                        adminUser = adminManager.findUser(email, password);
                        if (adminUser != null) {
                            session.setAttribute("user", adminUser);
                            session.setAttribute("usertype", "admin"); // set the type, it will be used when later accessing the user obj from session, so we know what to cast it as
                            //13-save the logged in user object to the session
                            request.getRequestDispatcher("adminView.jsp").include(request, response);
                            //14- redirect user to the main.jsp
                        } else {
                            //15-set user does not exist error to the session
                            session.setAttribute("existErr", "Error: User does not exist");
                            //16- redirect user back to the login.jsp
                            request.getRequestDispatcher("login.jsp").include(request, response);
                        }
                        break;
                        
                    default:
                        //15-set user type does not exist error to the session
                        session.setAttribute("existErr", "Error: User type does not exist");
                        //16- redirect user back to the login.jsp
                        request.getRequestDispatcher("login.jsp").include(request, response);
                       
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
