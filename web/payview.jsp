<%-- 
    Document   : paymentread
    Created on : 05/05/2021, 5:14:03 PM
    Author     : Briana Margetts
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <!-- <//jsp:include page="/PayController" flush="true" />-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Payment read Page</title>
    </head>
    <body> 
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>
        <h1>Your saved payment details</h1>
        <% if (request.getParameter("tos") != null && request.getParameter("tos").equals("yes")) {
            String paymentmethod = request.getParameter("paymentmethod");
            String accountnumber = request.getParameter("accountnumber");
            String ccv = request.getParameter("ccv");
         %>
        </br>
        <table id="paymentdetail">
            <tr>
                <th>Method</th>
                <td>${payment.paymentmethod}</td>
            </tr>
                <th>Account Number</th>
                <td>${payment.accountnumber}</td>
            </tr>
            <tr>
                <th>CVV Number</th> <!--CVV SHOUD NOT BE VISIBLE-->
                <td>${payment.ccv}</td>
            </tr>
            <tr>
                <td></td>
                <td><a href="paycreate.jsp">Update</a>
                <a href="index.jsp">Delete</a></td>
            </tr>    
        </table>
        <%
            //get customer id, get amount from order, get date from system
            Payment payment = new Payment(customerID, paymentmethod, accountnumber, ccv, ammount, date);
        %>
            
        <br>
       <h1>Payment History <input type="text" placeholder="Search..."> </h1>
       <br>        
       <table id="paymentdetail">
            <tr>
                <th>Payment ID</th>
                <th>Date</th>
                <th>Method</th>
                <th>Account Number</th>
                <th>CVV Number</th>

            </tr>
            <tr>
                <td>${payment.customerID}</td>         
                <td>${payment.date}</td>         
                <td>${payment.paymentmethod}</td>         
                <td>${payment.accountnumber}</td>         
                <td>${payment.ccv}</td>  <!--CVV SHOUD NOT BE VISIBLE-->      
            </tr>
        </table>
        
        
    </body>
</html>
