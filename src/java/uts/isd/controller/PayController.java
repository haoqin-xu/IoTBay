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
        response.setContentType("text/html");
        
             int paymentid = Integer.parseInt(request.getParameter("paymentid"));
             int methodid = Integer.parseInt(request.getParameter("methodid"));
             double ammount= Double.parseDouble(request.getParameter("ammount"));
             String date = request.getParameter("date");
             
             PaymentValidator validator = new PaymentValidator();
             //Payment Payment = null;
             PaymentManager manager = (PaymentManager) session.getAttribute("manager");
             validator.clear(session);

        try{
            manager.createPayment(paymentid,methodid,ammount,date);
            Payment payment = new Payment(paymentid,methodid,ammount,date);
            session.setAttribute("payment", payment);
            request.getRequestDispatcher("paycreate.jsp").include(request, response);

        }
        
        catch (SQLException exception) 	    
        {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    }

    



    

