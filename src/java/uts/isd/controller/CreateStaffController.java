/*
 * CreateStaffController:
 *
 * This servlet is responsible for creating staff users (As admin)
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TED
 */
public class CreateStaffController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * This is called upon first loading the page.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // this is called from the admin home page
        
        // retrieve the current session
        HttpSession session = request.getSession();
        
        // clear session errors from previously accessing the staff creation page
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("existErr", "");
        
        request.getRequestDispatcher("createStaff.jsp").include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
