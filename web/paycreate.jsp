<%-- 
    Document   : paycreate
    Created on : 06/05/2021, 4:48:39 PM
    Author     : Briana Margetts
--%>
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
        <br>
        <form action="payview.jsp" method="POST">
            <table>
                <tr>
                    <td>Payment Method:</td>
                    <td><input type="text" id="PAYMENTMETHOD" name="PAYMENTMETHOD"></td>
                </tr>
                <tr>
                    <td>Account Number:</td>
                    <td><input type="text" id="ACCOUNTNUMBER" name="ACCOUNTNUMBER"></td>
                </tr>
                <tr>
                    <td>CVV Number:</td>
                    <td><input type="password" id="CVVNUMBER" name="CVVNUMBER"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save Details"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
