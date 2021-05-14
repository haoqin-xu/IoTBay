<%-- 
    Document   : payupdate
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
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>
        <h1>Update your payment details</h1>
        <br>
       <%
             String paymentmethod = request.getParameter("paymentmethod");
             String accountnumber = request.getParameter("accountnumber");
             String ccv = request.getParameter("ccv");
             String paymentmethodErr = (String) session.getAttribute("paymentmethodErr");
             String accountnumberErr = (String) session.getAttribute("accountnumberErr");
             String ccvErr = (String) session.getAttribute("ccvErr");

        %>
        <form action="payview.jsp" method="post" method="get">
            <table>
                <tr>
                    <td>Payment Method:</td>
                    <td><select class="select" id="paymentmethod" name="paymentmethod">
                            <option value="<%= paymentmethod%>"><%= paymentmethod%></option>
                            <option value="Debit Card">Debit Card</option>
                            <option value="Credit Card">Credit Card</option>
                            <option value="Gift Card">Gift Card</option>
                            <option value="Prepaid Card">Pre-paid Card</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Account Number:</td>
                    <td><input type="text" id="accountnumber" name="accountnumber" value=<%=(accountnumberErr !=null ? accountnumberErr:accountnumber)%>></td>
                </tr>
                <tr>
                    <td>CCV Number:</td>
                    <td><input type="password" id="ccv" name="ccv" value="<%= ccv%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update Details"></td>
                    <!--put cancel button?-->
                </tr>
            </table>
        </form>
    </body>