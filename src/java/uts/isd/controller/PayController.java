/**
 *
 * @author Briana Margetts
 */
package uts.isd.controller;

import uts.isd.model.Payment;

import uts.isd.model.dao.PaymentManager;

import java.io.IOException;

import java.sql.SQLException;    

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



public class PayController extends HttpServlet {
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // retrieve the current session
        HttpSession session = request.getSession();
        
             int customerID = Integer.parseInt(request.getParameter("customerID"));
             String paymentmethod = (request.getParameter("paymentmethod"));
             String accountnumber = (request.getParameter("accountnumber"));
             int ccv= Integer.parseInt(request.getParameter("ccv"));
             double ammount= Double.parseDouble(request.getParameter("ammount"));
             String date = (request.getParameter("date"));
 
             //Payment  Payment = null;
             
             PaymentManager payment = (PaymentManager) session.getAttribute("manager");

        try{
           
            payment.createPayment(customerID,paymentmethod,accountnumber,ccv,ammount,date);

        }
        
        catch (SQLException exception) 	    
        {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    }

    



    

