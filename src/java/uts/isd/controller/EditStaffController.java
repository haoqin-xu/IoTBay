/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Staff;
import uts.isd.model.dao.StaffManager;

/**
 *
 * @author TED
 */
public class EditStaffController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // fetch current httpsession
        HttpSession session = request.getSession();
        
        // retrieve the Staff DAO manager from the session (it was initialised by the ConnServlet at index.jsp)
        StaffManager manager = (StaffManager) session.getAttribute("staffmanager");
        
        // create validator
        Validator validator = new Validator();
        
        // init staff object
        Staff staff = null;
       
        // clear session objects and errors relating to staff edit feature
        session.setAttribute("statoedit", null);
        session.setAttribute("editResult", "");

        // obtain the ID and other fields of the staff to be edited
        String staffEmail = request.getParameter("staemail");
        String staffPassword = request.getParameter("stapassword");

        // check whether staid field in request is empty
        if (request.getParameter("staemail") != null) { // if not empty, means controller was called from staff list view. so fetch user fields and put into table
            
            try { // obtain the staff object from the database
                staff = manager.findUser(staffEmail, staffPassword);
                session.setAttribute("statoedit", staff); // store staff object into session
                session.setAttribute("editResult", "Editing staff user "+staff.getName()+" with ID "+staff.getID()+".");
            } catch (SQLException ex) {
                Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("editResult", "Error: Staff user not found");
            }
        } else { // if empty, means controller was called from staff edit view, so parse request form parameters and update the user object in the DAO.  
            int ID = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String role = request.getParameter("role");
            
            if (!validator.validateEmail(email)) {
                //8-set incorrect email error to the session
                session.setAttribute("editResult", "Error: Email format incorrect");
            } else if (!validator.validatePassword(password)) {
                //11-set incorrect password error to the session
                session.setAttribute("editResult", "Error: Password format incorrect");
            } else { // if both the email and password is validated
                try {
                    manager.updateUser(ID, email, name, password, dob, phone, address, role);
                    session.setAttribute("statoedit", null);
                    session.setAttribute("editResult", "Details for staff user " + name + " with ID " + ID + " updated successfully.");
                } catch (SQLException ex) {
                    Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
                    session.setAttribute("editResult", "Error: Unable to update staff user details.");
                }
            }
        }
        // redirect the user back to the editStaff page, with the modified data
        request.getRequestDispatcher("editStaff.jsp").include(request, response);
    }
}
