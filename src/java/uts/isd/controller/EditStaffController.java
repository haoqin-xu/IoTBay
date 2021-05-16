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
        // check whether staid field in request is empty
        // if not empty, means controller was called from staff list view. so fetch user fields and put into table
        // if empty, means controller was called from staff edit view, so parse request form parameters and update the user object in the DAO.
        
        // fetch current httpsession
        HttpSession session = request.getSession();
        // retrieve the Staff DAO manager from the session (it was initialised by the ConnServlet at index.jsp)
        StaffManager manager = (StaffManager) session.getAttribute("staffmanager");
        // init the array list to store updated staff list
        ArrayList<Staff> resultArr = new ArrayList<Staff>();
        // init staff object
        Staff staff = null;
        // obtain the ID and other fields of the staff to be edited
        String email = request.getParameter("staemail");
        String password = request.getParameter("stapassword");
        
        try { // obtain the staff object from the database
            staff = manager.findUser(email, password);
            session.setAttribute("statoedit", staff); // store staff object into session
        } catch (SQLException ex) {
            Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // redirect the user back to the editStaff page, with the fetched user data
        request.getRequestDispatcher("editStaff.jsp").include(request, response);
    }
}
