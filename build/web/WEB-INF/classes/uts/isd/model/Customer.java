/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author TED
 */
public class Customer extends User {

    private final String role;
    
    public Customer(String email, String name, String password, String dob, String phone, String address) {
        super(email, name, password, dob, phone, address);
        this.role = "customer"; // only 1 customer role, customer objects will always have this role
    }

    public String getRole() {
        return role;
    }
}
