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
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestDevice().menu();
    }
    
    private DBConnector connector;
    private Connection conn;
    private DeviceManager manager;
    
    public TestDevice() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new DeviceManager(conn);
    }
    
    private void testCreate() throws SQLException {
        manager.createDevice(read("Device name: "), read("Manufacturer: "), read("Origin: "), read("Type: "), readBoolean("Instock: "), readDouble("Price Per Unit: "), readInteger("Number in Stock: "));
    }
    //Test Read working
    private void testRead() throws SQLException {
        Device device = manager.findDevice(read("Item Name: "), read("Item Type: "));
        System.out.println(device.getName() + " " + device.getManufacturer() + " " + device.getOrigin()+ " " + device.getType()+ " " + device.getInstock()+ " " + device.getPriceperunit()+ " " + device.getNumberinstock());
    }
    
    private void testUpdate() throws SQLException {
        manager.updateDevice(Integer.parseInt(read("Device ID: ")), read("Name: "), read("manufacturer"), read("origin"), read("type"), readBoolean("Instock: "), readDouble("Price Per Unit: "), readInteger("Number in Stock: "));
    }
    //Test Delete working
    private void testDelete() throws SQLException {
        manager.deleteDevice(Integer.parseInt(read("Device ID: ")));
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    
    private Boolean readBoolean(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextBoolean();
    }
    
    private Double readDouble(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextDouble();
    }
    
    private Integer readInteger(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextInt();
    }
    
    private void menu() throws SQLException{
        String c;
        while((c=read("Command [c/r/u/d/x]").equals("x"))){
            switch(c){
                case "c": testCreate();break;
                case "r": testRead(); break;
                case "u": testUpdate(); break;
                case "d": testDelete();break;
                default: help(); break;
            }
        }
    }
    
    private void help() {
        System.out.println("Database Operations: \n"
                + "c = Create Device \n"
                + "r = Read Device by Name and Type \n"
                + "u = Update Device by ID \n"
                + "d = Delete Device by ID\n"
                + "x = Exit\n");
    }
}
