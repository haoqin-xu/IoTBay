package uts.isd.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import uts.isd.model.Device;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DeviceManager;


/**
 *
 * @author danie
 */
public class TestDevice {
    private static Scanner in = new Scanner(System.in);
    //Main method initialises the test menu
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Testing device CRUD operations.");
        new TestDevice().menu();
    }
    //Setting up connection with database and manager
    private DBConnector connector;
    private Connection conn;
    private DeviceManager manager;
    
    public TestDevice() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new DeviceManager(conn);
    }
    //CREATE - creates a new device in the database
    private void testCreate() throws SQLException {
        manager.createDevice(read("Device name"), read("Manufacturer"), read("Origin"), read("Type"), readBoolean("Instock (true/false)"), readDouble("Price Per Unit"), readInteger("Number in Stock"));
    }
    //READ - finds a device in the database given a name and type
    private void testRead() throws SQLException {
        Device device = manager.findDevice(read("Item Name"), read("Item Type"));
        System.out.println(device.getName() + " " + device.getManufacturer() + " " + device.getOrigin()+ " " + device.getType()+ " " + device.getInstock()+ " " + device.getPriceperunit()+ " " + device.getNumberinstock());
    }
    //UPDATE - changes a devices details based on device ID
    private void testUpdate() throws SQLException {
        manager.updateDevice(Integer.parseInt(read("Device ID")), read("New Name"), read("New Manufacturer"), read("New Origin"), read("New Type"), readBoolean("Instock (true/false)"), readDouble("New Price Per Unit"), readInteger("Number in Stock"));
    }
    //DELETE - removes a device from the database based on device ID
    private void testDelete() throws SQLException {
        manager.deleteDevice(Integer.parseInt(read("Device ID")));
    }
    
    //Read functions to read different data types/user inputs
    //Read strings
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    //Read boolean
    private Boolean readBoolean(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextBoolean();
    }
    //Read double
    private Double readDouble(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextDouble();
    }
    //Read integer
    private Integer readInteger(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextInt();
    }
    
    //Menu function creates and displays the test cases menu
    private void menu() throws SQLException{
        String c;
        while(true){
            switch(c=read("Command [c/r/u/d/x or ?]")){
                case "c": testCreate();break;
                case "r": testRead(); break;
                case "u": testUpdate(); break;
                case "d": testDelete(); break;
                case "x": System.exit(0);
                case "?": help(); break;
                default: help(); break;
            }
        }
    }
    //Help function gives detail on each command in the menu
    private void help() {
        System.out.println("Database Operations: \n"
                + "c = Create Device \n"
                + "r = Read Device by Name and Type \n"
                + "u = Update Device by ID \n"
                + "d = Delete Device by ID\n"
                + "x = Exit\n");
    }
}
