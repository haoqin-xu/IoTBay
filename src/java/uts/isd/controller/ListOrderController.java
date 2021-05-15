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
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author Alec
 */
public class ListOrderController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //get the session from the request
        HttpSession session = request.getSession();
        //get connection with OrderManager DAO
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
        //Obtain customer object from user login
        Customer customerObj = (Customer) session.getAttribute("user");
        //get the id from the customer object and store into customerid
        int customerid = customerObj.getID();
        
        // initialise arraylist order to null
        ArrayList<Order> list = null;
        try {
            // use dao to access sql tables and store into list variable
            list = manager.listOrder(customerid);
            if(list!=null){
                // if list is not null set attribute to use in jsp
                session.setAttribute("orderlist", list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
        
    
    }

   

}
