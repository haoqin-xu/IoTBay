/*
 * ViewStaffController1:
 *
 * This servlet is responsible for fetching the list of staff (as an admin of
 * the system) as well as searching/displaying results for staff based on their
 * name or role.
 */
package uts.isd.controller;

import java.io.IOException;
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
public class ViewStaffController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewStaff</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewStaff at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    */

    // HttpServlet methods
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

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
        // fetch current httpsession
        HttpSession session = request.getSession();
        // retrieve the Staff DAO manager from the session (it was initialised by the ConnServlet at index.jsp)
        StaffManager manager = (StaffManager) session.getAttribute("staffmanager");
        // clear existing data/error messages stored in the session
        session.setAttribute("resultArr", null);
        session.setAttribute("notFoundErr", "");
        
        // obtain search params from the POST request
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        // create array to store search results
        ArrayList<Staff> resultArr = new ArrayList<Staff>();
        
        try { // use the staff manager to search for staff users
            resultArr.addAll(manager.searchUser(name, role));
        } catch (SQLException ex) {
            Logger.getLogger(ViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // check if there are any results from the search
        if (resultArr != null) { // if there are results
            session.setAttribute("resultArr", resultArr);
        } else { // if no results found, set an error message instead
            session.setAttribute("notFoundErr", "No staff users with the specified details were found.");
        }
        
        // redirect the user back to the viewStaff page, but now with results or errors stored in the session
        request.getRequestDispatcher("viewStaff.jsp").include(request, response);
    }

}
