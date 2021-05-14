/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.dao.DeviceManager;
import uts.isd.model.dao.OrderLineManager;
import uts.isd.model.dao.OrderManager;

/**
 *
 * @author Alec
 */
public class DeleteOrderController extends HttpServlet {

     @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //1- retrieve the current session
        HttpSession session = request.getSession();
        OrderLineManager orderlinemanager = (OrderLineManager)session.getAttribute("orderlinemanager");
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
        DeviceManager devicemanager = (DeviceManager) session.getAttribute("devicemanager");
        //2- create an instance of the Validator class 
        
        
       
        int orderid;
        
        
     
        try {
            orderid = Integer.parseInt(request.getParameter("orderid"));
            
            manager.deleteOrder(orderid);
            devicemanager.updateDeleteOrder(orderid);
            
            
        } catch(NumberFormatException exd){
            //catch numberformat exception when user inputs string or blank
            session.setAttribute("notint", "Error: orderid format incorrect");
            request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ViewOrder.jsp").forward(request, response);
        
        
        
        
            
        
    }

}
