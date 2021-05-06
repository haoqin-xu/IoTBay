<%-- 
    Document   : paymentread
    Created on : 05/05/2021, 5:14:03 PM
    Author     : Briana Margetts
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Payment read Page</title>
    </head>
    <body>
        <div>Your saved payment details</div>
        </br>
        <table id="paymentdetail">
            <tr>
                <th>Method</th>
                <td>1<!--Method--></td>
            </tr>
                <th>Account Number</th>
                <td>2<!--Account Num--></td>
            </tr>
            <tr>
                <th>CVV Number</th> <!--CVV SHOUD NOT BE VISIBLE-->
                <td>3<!--CVV Num--></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="index.jsp">Update</a>
                <a href="index.jsp">Delete</a></td>
            </tr>    
        </table>
        <br>
       <div>Payment History &#9;&#9;&#9;&#9; Search bar here</div> <!--SEARCH BAR HERE-->
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
                <td>1<!--payment id--></td>         
                <td>2<!--date--></td>         
                <td>3<!--method--></td>         
                <td>4<!--Account Num--></td>         
                <td>5<!--cvv num--></td>   <!--CVV SHOUD NOT BE VISIBLE-->      
            </tr>
        </table>
        
        
    </body>
</html>
