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
        
        
        HttpSession session = request.getSession();
        
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
       
    
        // retrieving anonymous user
        int customerid = Integer.parseInt(session.getAttribute("userid").toString());
        
        //line below is standard version
     //   int customerid = Integer.parseInt(request.getParameter("customerid"));
        ArrayList<Order> list = null;
        try {
            
            list = manager.listOrder(customerid);
            if(list!=null){
            session.setAttribute("orderlist", list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
        
    
    }

   

}
