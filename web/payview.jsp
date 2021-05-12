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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Payment read Page</title>
    </head>
    <body> 
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>
        <h1>Your saved payment details</h1>
        <% /*if (request.getParameter("tos") != null && request.getParameter("tos").equals("yes")) {
            String paymentmethod = request.getParameter("paymentmethod");
            String accountnumber = request.getParameter("accountnumber");
            String ccv = request.getParameter("ccv");
         */%>
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
                <th>CCV Number</th> <!--CCV SHOUD NOT BE VISIBLE-->
                <td>${payment.ccv}</td>
            </tr>
            <tr>
                <td></td>
                <td><a href="paycreate.jsp">Update</a>
                <a href="index.jsp">Delete</a></td>
            </tr>    
        </table>
            
        <br>
        
        
       <h1>Payment History</h1> 
       
       <form action="PaymentManager" method="POST">
       <table id="idSearch">
           <tr>
                <td><input type="text" placeholder="Search by ID..."></td>
                <td><input type="submit" value="Search"></td>
            </tr>
       </table>
       </form>
       
       <form action="PaymentManager" method="POST">
       <table id="dateSearch">
           <tr>
                <td><input type="text" placeholder="Search by Date..."></td>
                <td><input type="submit" value="Search"></td>
            </tr>
       </table>
       </form>
            
       <input type="text" placeholder="Search..."> <input type="text" placeholder="Search..."> 
       
       
       
       <br>
       <table id="paymentdetail">
            <tr>
                <th>Payment ID</th>
                <th>Date</th>
                <th>Method</th>
                <th>Account Number</th>
                <th>CVV Number</th>

            </tr>
            
            <% //for(int i=0; i<5; i++){%>
            <!-- for loop here -->
            <tr>
                <td>${payment.customerID}</td>         
                <td>${payment.date}</td>         
                <td>${payment.paymentmethod}</td>         
                <td>${payment.accountnumber}</td>         
                <td>${payment.ccv}</td>  <!--CVV SHOUD NOT BE VISIBLE-->      
            </tr>
            <%//}%>
        </table>
        
        
    </body>
</html>
