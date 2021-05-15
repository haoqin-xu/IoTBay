
/**
 *
 * @author Briana Margetts
 */
package uts.isd.controller;

import uts.isd.model.PaymentMethod;

import uts.isd.model.dao.PaymentMethodManager;

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



public class CreatePaymentMethod extends HttpServlet {
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // retrieve the current session
        HttpSession session = request.getSession();
             PaymentValidator validator = new PaymentValidator();
             //int methodid = Integer.parseInt(request.getParameter("methodid"));
              Customer customer = (Customer) session.getAttribute("user");
              int customerid = customer.getID();
             //int customerid = Integer.parseInt(request.getParameter("customerid"));
             
             String paymenttype = (request.getParameter("paymenttype"));
             int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
             int ccv = Integer.parseInt(request.getParameter("ccv"));
             
             
             //PaymentMethod paymentMethod = null;
             PaymentMethodManager paymentmethodmanager = (PaymentMethodManager) session.getAttribute("paymentmethodmanager");
             validator.clear(session);
             
            PaymentMethod paymentMethod = new PaymentMethod( customerid, paymenttype, accountnumber, ccv);
            
        try {
            paymentmethodmanager.createPaymentMethod(customerid, paymenttype, accountnumber, ccv);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.getRequestDispatcher("payview.jsp").include(request, response);
    }
}


    



    

