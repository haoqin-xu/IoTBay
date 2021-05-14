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
        
        //get current session
        HttpSession session = request.getSession();
        //initialise connection to DAO for ordervalidator and orderlinemanager
        OrderValidator ordervalidator = new OrderValidator();
        OrderLineManager manager = (OrderLineManager) session.getAttribute("orderlinemanager");
        //get the stored listorder from session to check if orderid is in order list
        ArrayList<Order> listorder = (ArrayList<Order>) session.getAttribute("validateorder");
        // initialise order as null
        OrderLineItem order = null;
        
        // create orderid variable   
        int orderid;
        
        try {
            //parse orderid in try and catch to catch if orderid is string or miss input
            orderid = Integer.parseInt(request.getParameter("orderid"));
            // clear the current validation
            ordervalidator.clear(session);
            // user findorderline to find the specific order to update
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
        catch(NumberFormatException exd){

            session.setAttribute("notint", "Error: orderid format incorrect");
            request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
        }
      
        }
    
    }


