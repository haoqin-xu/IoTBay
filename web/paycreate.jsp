<%-- 
    Document   : paycreate
    Created on : 06/05/2021, 4:48:39 PM
    Author     : Briana Margetts
--%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/mainstyle.css">
        <title>IoTBay - Payment Management Page</title>
    </head>
    <body>
        <%
            //getting error mesages
            /*
             String paymentmethodErr = (String) session.getAttribute("paymentmethodErr");
             String accountnumberErr = (String) session.getAttribute("accountnumberErr");
             String ccvErr = (String) session.getAttribute("ccvErr");
             */
        %>   
        <div>
            <div class="topnav"><div class="htop">IoTBay</div><a href="logout.jsp">Logout</a><a href="index.jsp">Home</a></div>
        </div>
        <h1>Please enter your payment details</h1>
        <br>
        <!--form calls create payment method controller upon submit-->
        <form action="CreatePaymentMethod" method="post">
            <table>
                <tr>
                    <!--getting payment method, customer can only select from drop down box-->
                    <td>Payment Method:</td>
                    <%/*=(paymentmethodErr !=null ? paymentmethodErr:"")*/%>
                    <td><select class="select" id="paymenttype" name="paymenttype">
                            <option id="paymenttype" name="paymenttype" value="">select payment method</option>
                            <option id="paymenttype" name="paymenttype" value="Debit Card">Debit Card</option>
                            <option id="paymenttype" name="paymenttype" value="Credit Card">Credit Card</option>
                            <option id="paymenttype" name="paymenttype"value="Gift Card">Gift Card</option>
                            <option id="paymenttype" name="paymenttype" value="Prepaid Card">Pre-paid Card</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <!--getting account number from customer, must be integer-->
                    <td>Account Number:</td>
                    <%/*=(accountnumberErr !=null ? accountnumberErr:"")*/%>
                    <td><input type="number" id="accountnumber" name="accountnumber"></td>
                </tr>
                <tr>
                    <!--getting ccv number from customer, must be integer-->
                    <td>CCV Number:</td>
                    <%/*=(ccvErr !=null ? ccvErr:"")*/%> 
                    <!--type is set to password to satisfy security requirements-->
                    <td><input type="password" id="ccv" name="ccv"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save Details" href="payview.jsp"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
