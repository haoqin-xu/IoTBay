
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



public class DeletePaymentMethod extends HttpServlet {
    private PaymentMethodManager pmethodmanager;
    
      
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // retrieve the current session
            HttpSession session = request.getSession();
             pmethodmanager =  (PaymentMethodManager) session.getAttribute("paymentmethodmanager");
             //Customer customer = (Customer) session.getAttribute("user");
             session.setAttribute("deleteErr", "");
            
             int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
             
        try {
            pmethodmanager.deletePaymentMethod(accountnumber);
            session.setAttribute("deleteErr", "ACCOUNT NUMBER  "+accountnumber+"  DELETED SUCCESSFULLY");


        } catch (SQLException ex) {
            session.setAttribute("deleteErr", "ERROR: ACCOUNT NUMBER NOT FOUND!");
            Logger.getLogger(CreatePaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }      
            request.getRequestDispatcher("payview.jsp").include(request, response);
    }
}


    



    

