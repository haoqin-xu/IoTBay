/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.CustomerManager;

public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("successMsg", "");
        
        request.getRequestDispatcher("register.jsp").include(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        CustomerManager manager = (CustomerManager) session.getAttribute("manager");
        
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("successMsg", "");
   
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else { 
            try {
                manager.addUser(email, name, password, dob, phone, address, role); 
                session.setAttribute("successMsg", "SUCCESS: Customer user "+name+" has been added to the database." ); 
                request.getRequestDispatcher("register.jsp").include(request, response); 
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
