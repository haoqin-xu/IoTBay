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

import uts.isd.model.Customer;

import uts.isd.model.dao.CustomerManager;

public class RegisterController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        CustomerManager manager = (CustomerManager) session.getAttribute("manager");

        validator.clear(session); //clears previous error mesages

        Customer user = null;

        if (!validator.validateEmail(email)) {
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the Register.jsp
            request.getRequestDispatcher("register.jsp").include(request, response);

        } 
        else if (!validator.validatePassword(password)) {
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the Register.jsp
            request.getRequestDispatcher("register.jsp").include(request, response);

        } 
        else {
            try {
                //6- find user by email and password
                user = manager.findUser(email, password);
                if (user != null) {
                    session.setAttribute("existErr", "Error: User already exist");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    manager.addUser(email, name, password, dob, phone, address, role); 
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
