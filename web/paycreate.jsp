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
        <title>IoTBay - Payment Management Page</title>
    </head>
    <body>
        <%
             PaymentMethod pay = (PaymentMethod) session.getAttribute("pay");
             String paymentmethodErr = (String) session.getAttribute("paymentmethodErr");
             String accountnumberErr = (String) session.getAttribute("accountnumberErr");
             String ccvErr = (String) session.getAttribute("ccvErr");
             
        %>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>
        <h1>Please enter your payment details</h1>
        <br>
        <form action="CreatePaymentMethod" method="post">
            <table>
                <tr>
                    <td>Payment Method:</td>
                     <%=(paymentmethodErr !=null ? paymentmethodErr:"")%>
                    <td><select class="select" id="paymentmethod" name="paymentmethod">
                            <option value="">select payment method</option>
                            <option value="Debit Card">Debit Card</option>
                            <option value="Credit Card">Credit Card</option>
                            <option value="Gift Card">Gift Card</option>
                            <option value="Prepaid Card">Pre-paid Card</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Account Number:</td>
                     <%=(accountnumberErr !=null ? accountnumberErr:"")%>
                    <td><input type="text" id="accountnumber" name="accountnumber"></td>
                </tr>
                <tr>
                    <td>CCV Number:</td>
                    <%=(ccvErr !=null ? ccvErr:"")%> 
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
