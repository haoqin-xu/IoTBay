<%-- 
    Document   : paycreate
    Created on : 06/05/2021, 4:48:39 PM
    Author     : Briana Margetts
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Payment Management Page</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>

        <h1>Please enter your payment details</h1>
         <%
            String paymentmethod = (String) session.getAttribute("paymentmethod");
            String accountnumber = (String) session.getAttribute("accountnumber");
            String ccv = (String) session.getAttribute("ccv");
        %>
        <br>
        <form action="payview.jsp" method="POST">
            <table>
                <tr>
                    <%= paymentmethod != null ? paymentmethod : "" %>
                    <td>Payment Method:</td>
                    <td><input type="text" id="paymentmethod" name="paymentmethod"></td>
                </tr>
                <tr>
                    <%= accountnumber != null ? accountnumber : "" %>
                    <td>Account Number:</td>
                    <td><input type="text" id="accountnumber" name="accountnumber"></td>
                </tr>
                <tr>
                    <%= ccv != null ? ccv : "" %>
                    <td>CVV Number:</td>
                    <td><input type="password" id="ccv" name="ccv"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save Details"></td>
                </tr>
            </table>
                   <% if(request.getAttribute("error")!=null){ %>
                       <script>alert("incorrect information");</script>
                       <% } %> 
        </form>
    </body>
</html>
