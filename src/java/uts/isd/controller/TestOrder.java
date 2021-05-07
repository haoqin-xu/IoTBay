/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
/**
 *
 * @author Alec
 */
public class TestOrder {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnector connector = new DBConnector();
        Connection conn = connector.openConnection();
        OrderManager db = new OrderManager(conn);
        
        System.out.println("DAO Tester for Order object");
        
        while (true) {
            System.out.print("Enter Command (Type 'H' for help): ");
            String input = in.nextLine().toLowerCase(); // take input as string, and converts to lowercase
            
            switch (input) { // parses command and execute relevant function
                case "h":
                    System.out.println("Displaying available commands: ");
                    System.out.println("C - create a order in the db");
                    System.out.println("R - retrieve order from the db using orderid and date");
                    System.out.println("U - update all of a order fields in the db");
                    System.out.println("D - delete a order from the db");
                    System.out.println("H - displays this help message");
                    System.out.println("Q - terminates the test program");
                    break;
                    
                case "c":
                    create(db); // calls create functionality
                    break;
                    
                case "r":
                    retrieve(db); // calls retrieve function
                    break;
                    
                case "u":
                    update(db); // update function
                    break;
                    
                case "d":
                    delete(db); // delete function
                    break;
                    
                case "q":
                    System.out.println("Test program shutting down...");
                    System.exit(0);
                    
                default:
                    System.out.println("Unknown command. Type 'H' for help, or 'Q' to quit.");
                    break;
            }
        }
         
    }
    
    private static void create(OrderManager db) {
        System.out.println("Creating Order in the database: ");
        
        try {
            System.out.print("StaffID: ");
            int StaffID = in.nextInt();
            
            System.out.print("PaymentID: ");
            int PaymentID = in.nextInt();
            
            System.out.print("DeviceID: ");
            int DeviceID = in.nextInt();
            in.nextLine();
                    
            System.out.print("Status: ");
            String Status = in.nextLine();
            
            System.out.print("InvoiceID: ");
            int InvoiceID = in.nextInt();
            in.nextLine();
            
            System.out.print("Date: ");
            String Date = in.nextLine();

            
            db.createOrder(StaffID, PaymentID, DeviceID, Status, InvoiceID, Date);
            System.out.println("Order is added to the database.");

        } catch (SQLException ex) {
            Logger.getLogger(TestDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void retrieve(OrderManager db) {
        System.out.println("Retrieving an order from the database: ");
        
        try {
            System.out.print("OrderID: ");
            int orderid = in.nextInt();
            in.nextLine();
            System.out.print("Date: ");
            String date = in.nextLine();
            
            if (db.findOrder(orderid, date) == null) {
                System.out.println("User not found. Incorrect orderid or date.");
            } else {
                System.out.println("User found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TestDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void update(OrderManager db) {
        System.out.println("Updating all of an order in the database based on their ID: ");
        
        try {
            System.out.print("Order ID: ");
            int ID = Integer.parseInt(in.nextLine());
            
            System.out.print("New StaffID: ");
            int StaffID = in.nextInt();
            System.out.print("New PaymentID: ");
            int PaymentID = in.nextInt();
            System.out.print("New DeviceID: ");
            int DeviceID = in.nextInt();
            in.nextLine();
            
            System.out.print("New Status: ");
            String Status = in.nextLine();
            
            System.out.print("New InvoiceID: ");
            int InvoiceID = in.nextInt();
            in.nextLine();
            
            System.out.print("New Date: ");
            String Date = in.nextLine();
            
            db.updateOrder(ID, StaffID, PaymentID, DeviceID, Status, InvoiceID, Date);
            System.out.println("Order fields updated");

        } catch (SQLException ex) {
            Logger.getLogger(TestDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void delete(OrderManager db) {
        System.out.println("Deleting admin user from the database based on ID: ");
        
        try {
            System.out.print("Order ID: ");
            int ID = Integer.parseInt(in.nextLine());
            db.deleteOrder(ID);
            System.out.println("Order was deleted.");
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
