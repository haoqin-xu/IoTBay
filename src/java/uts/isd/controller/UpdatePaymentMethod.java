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



public class UpdatePaymentMethod extends HttpServlet {
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // retrieve the current session
        HttpSession session = request.getSession();
            //int methodid, int customerid, String paymenttype, int accountnumber, int ccv
             int methodid = Integer.parseInt(request.getParameter("methodid"));
             int customerid = Integer.parseInt(request.getParameter("customerid"));
             String paymenttype = (request.getParameter("paymenttype"));
             int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
             int ccv = Integer.parseInt(request.getParameter("ccv"));

             
             PaymentValidator validator = new PaymentValidator();
             //Payment Payment = null;
             PaymentMethodManager manager = (PaymentMethodManager) session.getAttribute("manager");
             validator.clear(session);

        try{
           //paymentid, int methodid, double ammount, String date)
            manager.createPaymentMethod( customerid, paymenttype, accountnumber, ccv);
            PaymentMethod paymentMethod = new PaymentMethod( customerid, paymenttype, accountnumber, ccv);
            //session.setAttribute("paymentMethod", paymentMethod);
            request.getRequestDispatcher("paycreate.jsp").include(request, response);

        }
        
        catch (SQLException exception) 	    
        {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    }

    



    

