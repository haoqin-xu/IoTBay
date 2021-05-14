/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;

/**
 *
 * @author Alec
 */
public class OrderValidator extends HttpServlet {

    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "[a-z0-9]{4,}";
    private String numberPattern = "[0-9]+";

    public OrderValidator() {
    }
    
    public boolean inlist(ArrayList<Order> listorder,int orderid){
        for (Order elements: listorder)
        {
            if (elements.getOrderID() == orderid){
                return true;
            } 
        }
        return false;
    }
    public boolean isNumber(String number){
        return number.matches("[0-9]+");
    }
    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();

    }

    public boolean checkEmpty(String email, String password) {

        return email.isEmpty() || password.isEmpty();

    }

    public boolean validateEmail(String email) {

        return validate(emailPattern, email);

    }

    public boolean validateName(String name) {

        return validate(namePattern, name);

    }

    public boolean validatePassword(String password) {

        return validate(passwordPattern, password);

    }
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("existErr", "");
    }

}
