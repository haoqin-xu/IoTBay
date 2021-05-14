/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import uts.isd.model.Payment;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author Briana Margetts
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
    public void createPayment(int paymentid, int methodid, double ammount, String date) throws SQLException {
        String columns = "INSERT INTO iotdb.PAYMENT(METHODID,AMMOUNT,PAYMENTDATE)";
        String values = "VALUES("+methodid+", "+ammount+", '"+date+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find payment by PAYMENTID and date in the database
  
        Assignment suggests using PaymentID and date of the payment to find payments in the database
    */
    public Payment findPaymentID(int paymentid) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.PAYMENT WHERE PAYMENTID="+paymentid+"";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific payment using the parameters               
        while(rs.next()) {
            int Paymentid = rs.getInt(1);            
            if ((Paymentid == paymentid)) {
                int Methodid = rs.getInt(2);
                double Ammount = rs.getDouble(3);
                String Date = rs.getString(4);
                
                return new Payment(Paymentid, Methodid, Ammount, Date); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
        public Payment findPaymentDate(String date) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.PAYMENT WHERE PAYMENTDATE="+date+"";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific payment using the parameters               
             while(rs.next()) {
            String Date = rs.getString(4);
            if ((Date == date)) {
                int Paymentid = rs.getInt(1);            
                int Methodid = rs.getInt(2);
                double Ammount = rs.getDouble(3);
                
                return new Payment(Paymentid, Methodid, Ammount, Date); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of PAYMENT based on ID
    */    
    public void updatePayment(int paymentid, int methodid, double ammount, String date) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE IOTDB.PAYMENT SET PAYMENTID="+paymentid+", METHODID="+methodid+", AMMOUNT="+ammount+", DATE="+date+"";
        String where = "where PAYMENTID="+paymentid+"";
        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete PAYMENT based on PAYMENTID
    */
    public void deletePayment(int paymentid) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.PAYMENT where PAYMENTID="+paymentid+"";
       st.executeUpdate(delete);
    }
    
    
    /* fetch all payments. fetch all payments in array */
    public ArrayList<Payment> getPaymentArray() throws SQLException{
        //code to make payment array 
        String list = "SELECT * FROM IOTDB.PAYMENT";
        ResultSet rs = st.executeQuery(list);
        ArrayList<Payment> PaymentList = new ArrayList<Payment>();
       
        while(rs.next()){
            
            int paymentid = rs.getInt(1);
            int methodid = rs.getInt(2);
            double ammount = rs.getDouble(3);
            String date = rs.getString(4);
            Payment pay = new Payment(paymentid, methodid, ammount, date);
        
            PaymentList.add(pay);
        }
        return PaymentList;
   }
    
  
}
