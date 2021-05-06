/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import uts.isd.model.Admin;

/**
 *
 * @author TED
 */
public class AdminManager {
    private Statement st;
    
    public AdminManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create admin user & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void addUser(String email, String name, String password, String dob, String phone, String address, String role) throws SQLException {
        String columns = "insert into iotdb.ADMIN(EMAIL,\"NAME\",PASSWORD,DOB,PHONE,ADDRESS,ROLE)";
        String values = "VALUES('"+email+"', '"+name+"', '"+password+"', '"+dob+"', '"+phone+"', '"+address+"', '"+role+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find admin user by email and password in the database
  
        Email is used here for login purposes; while it isn't the primary key,
        it is more reasonable for users to remember their email than  a randomly
        generated integer ID.
    */
    public Admin findUser(String email, String password) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.ADMIN WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'";// read from where email = and password =
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        
        //search the ResultSet for a user using the parameters               
        while(rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(4);
            
            if (userEmail.equals(email) && userPass.equals(password)) {
                int ID = rs.getInt(1);
                String name = rs.getString(3);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String dob = rs.getString(7);
                String role = rs.getString(8);
                
                return new Admin(ID, email, name, password, dob, phone, address, role); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of admin user based on ID
    */    
    public void updateUser(int ID, String email, String name, String password, String dob, String phone, String address, String role) throws SQLException {       
        //code for update-operation   
        String update = "update iotdb.ADMIN set EMAIL='"+email+"', NAME='"+name+"', PASSWORD='"+password+"', DOB='"+dob+"', PHONE='"+phone+"', ADDRESS='"+address+"', ROLE='"+role+"'";
        String where = "where ID='"+ID+"'";

        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete admin user based on ID
    */
    public void deleteUser(int ID) throws SQLException{       
       //code for delete-operation   
       String delete = "delete from iotdb.ADMIN where ID='"+ID+"'";
       
       st.executeUpdate(delete);
    }
}
