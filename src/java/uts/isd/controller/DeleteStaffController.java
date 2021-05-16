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
public class DeleteStaffController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // fetch current httpsession
        HttpSession session = request.getSession();
        // retrieve the Staff DAO manager from the session (it was initialised by the ConnServlet at index.jsp)
        StaffManager manager = (StaffManager) session.getAttribute("staffmanager");
        // init the array list to store updated staff list
        ArrayList<Staff> resultArr = new ArrayList<Staff>();
        // obtain the ID of the staff to be deleted from the httprequest
        int staffToDeleteID = Integer.parseInt(request.getParameter("staid"));
        // clear any existing session errors attributed to staff deletion.
        session.setAttribute("deleteResult", "");

        try {
            manager.deleteUser(staffToDeleteID); // empty strings
            session.setAttribute("deleteResult", "Staff with ID " + staffToDeleteID + " has been deleted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("deleteResult", "Unable to delete staff");
        }

        /*
            After the staff has been deleted, the staff list to be displayed 
            needs also to be updated. All staff users is fetched from the
            database again.
        */
        try {
            resultArr = manager.searchUser("", ""); // empty strings
        } catch (SQLException ex) {
            Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // check if there are any results from the search
        if (resultArr != null) { // if there are results
            session.setAttribute("resultArr", resultArr);
        } else { // if no results found, set an error message instead
            session.setAttribute("notFoundErr", "No staff in the database.");
        }
        
        // redirect the user back to the viewStaff page, but now with results or errors stored in the session
        request.getRequestDispatcher("viewStaff.jsp").include(request, response);
    }
}
