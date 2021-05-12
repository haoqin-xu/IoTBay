/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.dao.OrderManager;

/**
 *
 * @author Alec
 */
public class UpdateOrderController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
       
        PrintWriter ps = response.getWriter();
        int orderid = Integer.parseInt(session.getAttribute("orderid").toString());
        int customerid = Integer.parseInt(request.getParameter("customerid"));
        int paymentid = Integer.parseInt(request.getParameter("paymentid"));
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        
        
        int invoiceid = Integer.parseInt(request.getParameter("invoiceid"));
        String date = request.getParameter("date");
        
        try {
            
            manager.updateOrder(orderid,customerid,paymentid,deviceid,invoiceid,date);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
        
    
    }
  


}
