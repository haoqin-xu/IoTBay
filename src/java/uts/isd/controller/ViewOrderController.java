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
import uts.isd.model.OrderLineItem;
import uts.isd.model.dao.OrderLineManager;

/**
 *
 * @author Alec
 */
public class ViewOrderController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        OrderValidator ordervalidator = new OrderValidator();
        OrderLineManager manager = (OrderLineManager) session.getAttribute("orderlinemanager");
       
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        
        ArrayList<Order> listorder = (ArrayList<Order>) session.getAttribute("validateorder");
        
        OrderLineItem order = null;
     //   if (!ordervalidator.isNumber(Integer.toString(orderid))){
            // set error if input was not an integer
      //      session.setAttribute("notint", "Error: orderid format incorrect");
            // redirect user back to the vieworder.jsp
      //      request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
      //  }
       // else{
            try {
                order = manager.findOrderLine(orderid);
                if(order!=null && ordervalidator.inlist(listorder,orderid)){
                session.setAttribute("detailedorder", order);
                request.getRequestDispatcher("UpdateOrder.jsp").include(request, response);
                }
                else{
                    session.setAttribute("outoflist", "Error: Orderid not found on list of orders");
                    request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
      //  request.getRequestDispatcher("UpdateOrder.jsp").include(request, response);
        }
    
    }

}
