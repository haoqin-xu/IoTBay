/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import uts.isd.model.Order;

/**
 *
 * @author 61452
 */
public class OrderManager {
    private Statement st;
    
    public OrderManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create new order & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void addOrder(int staffID, int paymentID, int deviceID, String status, int invoiceID, String deliveryDate) throws SQLException {
        String columns = "insert into iotdb.ORDER(STAFFID,PAYMENTID,DEVICEID,STATUS,INVOICEID,DELIVERYDATE)";
        String values = "VALUES('"+staffID+"', '"+paymentID+"', '"+deviceID+"', '"+status+"', '"+invoiceID+"', '"+deliveryDate+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find an order by its ID in the database
  
        Email is used here for login purposes; while it isn't the primary key,
        it is more reasonable for users to remember their email than  a randomly
        generated integer ID.
    */
    public Order findOrder(int ID) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.ORDER WHERE ORDERID='"+ID+"'";// read from where email = and password =
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        
        //search the ResultSet for a user using the parameters               
        while(rs.next()) {
            int OrderID = rs.getInt(1);
            
            if (OrderID == ID) {
                int staffID = rs.getInt(2);
                int paymentID = rs.getInt(3);
                int deviceID = rs.getInt(4);
                String status = rs.getString(5);
                int invoiceID = rs.getInt(6);
                String deliveryDate = rs.getString(7);
                
                return new Order(staffID, paymentID, deviceID, status, invoiceID, deliveryDate); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of an order based on its ID
    */    
    public void updateOrder(int orderID, int staffID, int paymentID, int deviceID, String status, int invoiceID, String deliveryDate) throws SQLException {       
        //code for update-operation   
        String update = "update iotdb.ORDER set STAFFID='"+staffID+"', PAYMENTID='"+paymentID+"', DEVICEID='"+deviceID+"', STATUS='"+status+"', INVOICEID='"+invoiceID+"', DELIVERYDATE='"+deliveryDate+"'";
        String where = "where ORDERID="+orderID+"";

        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete order user based on ID
    */
    public void deleteUser(int orderID) throws SQLException{       
       //code for delete-operation   
       String delete = "delete from iotdb.ORDER where ORDERID="+orderID+"";
       
       st.executeUpdate(delete);
    }
}
