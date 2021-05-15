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
        manager.createDevice(read("name"), read("manufacturer"), read("origin"), read("type"), read("instock"), Double.parseDouble(read("priceperunit")), Integer.parseInt(read("numberinstock")));
    }
    
    private void testRead() throws SQLException {
        Device device = manager.findDevice(read("Name"), read("Type"));
        System.out.println(device.getName() + " " + device.getManufacturer() + " " + device.getOrigin()+ " " + device.getType()+ " " + device.getInstock()+ " " + device.getPriceperunit()+ " " + device.getNumberinstock());
    }
    
    private void testUpdate() {
        
    }
    
    private void testDelete() {
        
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    
    private void menu() throws SQLException{
        char c;
        while((c=read("Command [c/r/u/d/x]").charAt(0)) != 'x'){
            switch(c){
                case 'c': testCreate();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
                //default: help(); break;
            }
        }
    }
}
