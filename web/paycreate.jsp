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
             String customerIDErr =  (String) session.getAttribute("customerIDErr");
             String paymentmethodErr = (String) session.getAttribute("paymentmethodErr");
             String accountnumberErr = (String) session.getAttribute("accountnumberErr");
             String ccvErr = (String) session.getAttribute("ccvErr");
             String ammountErr= (String) session.getAttribute("ammountErr");
             String dateErr = (String) session.getAttribute("dateErr");
             Payment paymentErr = (Payment) request.getAttribute("paymentErr");
        %>
        
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>

        <h1>Please enter your payment details</h1>

        <br>
        <form action="payview.jsp" method="post" method="get">
            <table>
                <tr>
                    <td>Payment Method:</td>
                     <%=(paymentmethodErr !=null ? paymentmethodErr:"")%>
                    <td><input type="text" id="paymentmethod" name="paymentmethod"></td>
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
                    <!--<td><%//=payment.getCcv()%></td>-->

                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save Details"></td>
                </tr>
            </table>
 
        </form>
    </body>
</html>
