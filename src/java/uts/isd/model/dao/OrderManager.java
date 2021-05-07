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
 * @author Alec
 */
public class OrderManager {
    private Statement st;
    
    public OrderManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create Order & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void createOrder(int StaffID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) throws SQLException {
        String columns = "INSERT INTO iotdb.\"ORDER\"(STAFFID,PAYMENTID,DEVICEID,STATUS,INVOICEID,\"DATE\")";
        String values = "VALUES("+StaffID+", "+PaymentID+", "+DeviceID+", '"+Status+"', "+InvoiceID+", '"+Date+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
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
                int StaffID = rs.getInt(2);
                int PaymentID = rs.getInt(3);
                int DeviceID = rs.getInt(4);
                String Status = rs.getString(5);
                int InvoiceID = rs.getInt(6);
                
                return new Order(OrderID, StaffID, PaymentID, DeviceID, Status, InvoiceID, Date); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of ORDER based on ID
    */    
    public void updateOrder(int OrderID, int StaffID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE iotdb.\"ORDER\" SET STAFFID="+StaffID+", PAYMENTID="+PaymentID+", DEVICEID="+DeviceID+", STATUS='"+Status+"', INVOICEID="+InvoiceID+", DATE='"+Date+"'";
        String where = "where ORDERID="+OrderID+"";
        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete ORDER based on ORDERID
    */
    public void deleteOrder(int OrderID) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.\"ORDER\" where ORDERID="+OrderID+"";
       st.executeUpdate(delete);
    }
}
