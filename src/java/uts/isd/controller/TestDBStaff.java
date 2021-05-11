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

public class TestDBStaff {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnector connector = new DBConnector();
        Connection conn = connector.openConnection();
        StaffManager db = new StaffManager(conn);
        
        System.out.println("DAO Tester for Staff object");
        
        while (true) {
            System.out.print("Enter Command (Type 'H' for help): ");
            String input = in.nextLine().toLowerCase(); // take input as string, and converts to lowercase
            
            switch (input) { // parses command and execute relevant function
                case "h":
                    System.out.println("Displaying available commands: ");
                    System.out.println("C - create a user in the db");
                    System.out.println("R - retrieve user from the db using email and password");
                    System.out.println("U - update all of a user's fields in the db");
                    System.out.println("D - delete a user from the db");
                    System.out.println("S - Search for a user from the db based on name and role");
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
                    
                case "s":
                    search(db);
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
    
    private static void create(StaffManager db) {
        System.out.println("Creating staff user in the database: ");
        
        try {
            System.out.print("User email: ");
            String email = in.nextLine();
            System.out.print("User name: ");
            String name = in.nextLine();
            System.out.print("User password: ");
            String password = in.nextLine();
            System.out.print("User date of birth DD/MM/YY: ");
            String dob = in.nextLine();
            System.out.print("User phone: ");
            String phone = in.nextLine();
            System.out.print("User address: ");
            String address = in.nextLine();
            System.out.print("User role: ");
            String role = in.nextLine();
            
            db.addUser(email, name, password, dob, phone, address, role);
            System.out.println("Staff is added to the database.");

        } catch (SQLException ex) {
            Logger.getLogger(TestDBStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void retrieve(StaffManager db) {
        System.out.println("Retrieving a staff user from the database: ");
        
        try {
            System.out.print("User email: ");
            String email = in.nextLine();
            System.out.print("User password: ");
            String password = in.nextLine();
            
            if (db.findUser(email, password) == null) {
                System.out.println("User not found. Incorrect email or password.");
            } else {
                System.out.println("User found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TestDBStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void update(StaffManager db) {
        System.out.println("Updating all of a staff user's fields in the database based on their ID: ");
        
        try {
            System.out.print("User ID: ");
            int ID = Integer.parseInt(in.nextLine());
            System.out.print("New user email: ");
            String email = in.nextLine();
            System.out.print("New user name: ");
            String name = in.nextLine();
            System.out.print("New user password: ");
            String password = in.nextLine();
            System.out.print("New user date of birth DD/MM/YY: ");
            String dob = in.nextLine();
            System.out.print("New user phone: ");
            String phone = in.nextLine();
            System.out.print("New user address: ");
            String address = in.nextLine();
            System.out.print("New user role: ");
            String role = in.nextLine();
            
            db.updateUser(ID, email, name, password, dob, phone, address, role);
            System.out.println("Staff user fields updated");

        } catch (SQLException ex) {
            Logger.getLogger(TestDBStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void delete(StaffManager db) {
        System.out.println("Deleting staff user from the database based on ID: ");
        
        try {
            System.out.print("Staff user ID: ");
            int ID = Integer.parseInt(in.nextLine());
            
            db.deleteUser(ID);
            System.out.println("Staff user was deleted.");
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDBStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void search(StaffManager db) {
        System.out.println("Searching for staff users based on name and role: ");
        
        try {
            System.out.print("User name - leave empty to not use: ");
            String name = in.nextLine();
            System.out.print("User role - leave empty to not use: ");
            String role = in.nextLine();
            
            if (db.searchUser(name, role) == null) {
                System.out.println("No users found with specified parameters.");
            } else {
                System.out.println("Users found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TestDBStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}