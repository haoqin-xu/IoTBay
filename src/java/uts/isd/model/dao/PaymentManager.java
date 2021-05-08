/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import uts.isd.model.Payment;

/**
 *
 * @author 61452
 */
public class PaymentManager {
    private Statement st;
    
    public PaymentManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create Payment & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void createPayment(int customerID, String paymentmethod, String accountnumber, int ccv, double ammount, String date) throws SQLException {
        String columns = "INSERT INTO iotdb.PAYMENT(CUSTOMERID,PAYMENTMETHOD,ACCOUNTNUMBER,CCVNUMBER,AMMOUNT,PAYMENTDATE)";
        String values = "VALUES("+customerID+", "+paymentmethod+", "+accountnumber+", "+ccv+", "+ammount+", '"+date+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find payment by PAYMENTID and date in the database
  
        Assignment suggests using PaymentID and date of the payment to find payments in the database
    */
    public Payment findPayment(int PaymentID, String Date) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.PAYMENT WHERE PAYMENTID="+PaymentID+" AND PAYMENTDATE='"+Date+"'";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific payment using the parameters               
        while(rs.next()) {
            int paymentID = rs.getInt(1);
            String paymentDate = rs.getString(7);
            
            if ((paymentID == PaymentID) && paymentDate.equals(Date)) {
                int CustomerID = rs.getInt(2);
                String PaymentMethod = rs.getString(3);
                String AccountNumber = rs.getString(4);
                int CCV = rs.getInt(5);
                double Ammount = rs.getDouble(6);
                
                return new Payment(CustomerID, PaymentMethod, AccountNumber, CCV, Ammount, Date); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of PAYMENT based on ID
    */    
    public void updatePayment(int paymentID, int customerID, String paymentmethod, String accountnumber, int ccv, double ammount, String paymentdate) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE iotdb.PAYMENT SET CUSTOMERID="+customerID+", PAYMENTMETHOD="+paymentmethod+", ACCOUNTNUMBER="+accountnumber+", CCVNUMBER="+ccv+", AMMOUNT="+ammount+", PAYMENTDATE="+paymentdate+"";
        String where = "where PAYMENTID="+paymentID+"";
        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete PAYMENT based on PAYMENTID
    */
    public void deletePayment(int PaymentID) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.PAYMENT where PAYMENTID="+PaymentID+"";
       st.executeUpdate(delete);
    }
}
