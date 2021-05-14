/*
 * CreateStaffController:
 *
 * This servlet is responsible for creating staff users (As admin)
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
import uts.isd.model.dao.StaffManager;

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
        
        // clear previous session errors and messages
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("successMsg", "");
        
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
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        StaffManager manager = (StaffManager) session.getAttribute("staffmanager");
        
        // clear previous session errors and messages
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
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp
            request.getRequestDispatcher("createStaff.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp
            request.getRequestDispatcher("createStaff.jsp").include(request, response);

        } else { // if both the email and password is validated
            try {
                manager.addUser(email, name, password, dob, phone, address, role); // add the staff user to the database
                session.setAttribute("successMsg", "SUCCESS: Staff user "+name+" added to the database." ); // set success msg
                request.getRequestDispatcher("createStaff.jsp").include(request, response); // redirect to page
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
