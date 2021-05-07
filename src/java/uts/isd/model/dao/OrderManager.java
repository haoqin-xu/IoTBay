/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
<<<<<<< HEAD

import java.sql.*;
import uts.isd.model.Order;

/**
 *
 * @author 61452
=======
import java.sql.*;
import uts.isd.model.Order;
/**
 *
 * @author Alec
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
 */
public class OrderManager {
    private Statement st;
    
    public OrderManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
<<<<<<< HEAD
        CREATE OPERATION: Create new order & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void addOrder(int staffID, int paymentID, int deviceID, String status, int invoiceID, String deliveryDate) throws SQLException {
        String columns = "insert into iotdb.ORDER(STAFFID,PAYMENTID,DEVICEID,STATUS,INVOICEID,DELIVERYDATE)";
        String values = "VALUES('"+staffID+"', '"+paymentID+"', '"+deviceID+"', '"+status+"', '"+invoiceID+"', '"+deliveryDate+"')";
=======
        CREATE OPERATION: Create Order & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void createOrder(int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) throws SQLException {
        String columns = "INSERT INTO iotdb.\"ORDER\"(CUSTOMERID,PAYMENTID,DEVICEID,STATUS,INVOICEID,\"DATE\")";
        String values = "VALUES("+CustomerID+", "+PaymentID+", "+DeviceID+", '"+Status+"', "+InvoiceID+", '"+Date+"')";
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
        
        st.executeUpdate(columns+values);
    }
    
    /*
<<<<<<< HEAD
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
=======
        RETRIEVE OPERATION: Find order by OrderID and date in the database
  
        Assignment suggests using OrderID and date of the order to find orders in the database
    */
    public Order findOrder(int OrderID, String Date) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.\"ORDER\" WHERE ORDERID="+OrderID+" AND \"DATE\"='"+Date+"'";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific order using the parameters               
        while(rs.next()) {
            int orderID = rs.getInt(1);
            String orderDate = rs.getString(7);
            
            if ((orderID == OrderID) && orderDate.equals(Date)) {
                int CustomerID = rs.getInt(2);
                int PaymentID = rs.getInt(3);
                int DeviceID = rs.getInt(4);
                String Status = rs.getString(5);
                int InvoiceID = rs.getInt(6);
                
                return new Order(OrderID, CustomerID, PaymentID, DeviceID, Status, InvoiceID, Date); // return admin user object to view (to be stored in session)
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
            }
        }
        return null;
    }
    
    /*
<<<<<<< HEAD
        UPDATE OPERATION: Update all fields of an order based on its ID
    */    
    public void updateOrder(int orderID, int staffID, int paymentID, int deviceID, String status, int invoiceID, String deliveryDate) throws SQLException {       
        //code for update-operation   
        String update = "update iotdb.ORDER set STAFFID='"+staffID+"', PAYMENTID='"+paymentID+"', DEVICEID='"+deviceID+"', STATUS='"+status+"', INVOICEID='"+invoiceID+"', DELIVERYDATE='"+deliveryDate+"'";
        String where = "where ORDERID="+orderID+"";

=======
        UPDATE OPERATION: Update all fields of ORDER based on ID
    */    
    public void updateOrder(int OrderID, int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE iotdb.\"ORDER\" SET CUSTOMERID="+CustomerID+", PAYMENTID="+PaymentID+", DEVICEID="+DeviceID+", STATUS='"+Status+"', INVOICEID="+InvoiceID+", DATE='"+Date+"'";
        String where = "where ORDERID="+OrderID+"";
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
        st.executeUpdate(update+where); 
    }       

    /*
<<<<<<< HEAD
        DELETE OPERATION: Delete order user based on ID
    */
    public void deleteUser(int orderID) throws SQLException{       
       //code for delete-operation   
       String delete = "delete from iotdb.ORDER where ORDERID="+orderID+"";
       
=======
        DELETE OPERATION: Delete ORDER based on ORDERID
    */
    public void deleteOrder(int OrderID) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.\"ORDER\" where ORDERID="+OrderID+"";
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
       st.executeUpdate(delete);
    }
}
