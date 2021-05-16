/**
 *
 * @author Briana Margetts
 */
package uts.isd.controller;

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


    public class DeletePaymentMethod extends HttpServlet {

        private PaymentMethodManager pmethodmanager;

        @Override

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // retrieve the current session
            HttpSession session = request.getSession();
            // creating instance of payment method manager dao
            pmethodmanager = (PaymentMethodManager) session.getAttribute("paymentmethodmanager");
            //initalising delete error string
            session.setAttribute("deleteErr", "");
            // getting account number from current session
            int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));

            try {
                //checking number entered equals account number
                if (accountnumber == Integer.parseInt(request.getParameter("accountnumber"))) {
                    pmethodmanager.deletePaymentMethod(accountnumber);
                    //success message if the account numbers match
                    session.setAttribute("deleteErr", "ACCOUNT NUMBER  " + accountnumber + "  DELETED SUCCESSFULLY");
                } else {
                    //error message if the account numbers do not match
                    session.setAttribute("deleteErr", "ERROR: ACCOUNT NUMBER NOT FOUND!");
                }

            } catch (SQLException ex) {
                Logger.getLogger(CreatePaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
            //response dispatched back to payview.jsp
            request.getRequestDispatcher("payview.jsp").include(request, response);
        }
    }
