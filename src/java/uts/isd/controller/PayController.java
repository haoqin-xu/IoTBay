/**
 *
 * @author Briana Margetts
 */
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.Payment;

import uts.isd.model.dao.PaymentManager;

public class PayController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        
        //2- create an instance of the Validator class
        Validator validator = new Validator();
                
        //3 - capture the customer id
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        
        //4 - capture the payment method
        String paymentmethod = request.getParameter("paymentmethod");
        
        //5 - capture the account number       
        String accountnumber = request.getParameter("accountnumber");
        
        //6 - capture the cvv number
        int ccv = Integer.parseInt(request.getParameter("ccv"));

        //7 - capture the ammount      
        double ammount = Integer.parseInt(request.getParameter("ammount"));

        //8 - capture the payment date     
        String date = request.getParameter("date");
        
        //9 - retrieve the manager instance from session
        PaymentManager manager = (PaymentManager) session.getAttribute("manager");

        validator.clear(session); //clears previous error mesages

        Payment payment = null; 
    }
}


    

