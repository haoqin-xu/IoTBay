<%-- 
    Document   : CreateOrder
    Created on : 07/05/2021, 1:04:18 PM
    Author     : Alec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create order</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>

        <br>

                <h2>Iot device list</h2>

                <table>
                  <tr>
                    <th>Device ID</th>
                    <th>Name</th>
                    <th>Number in Stock</th>
                  </tr>
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                </table>

                <h2>Order</h2>
                <form action="OrderController" method="POST">
                    <table>
                        <tr>
                            <td>CustomerID:</td>
                            <td><input type="number" name="customerid"></td>
                        </tr>
                        <tr>
                            <td>PaymentID:</td>
                            <td><input type="number" name="paymentid"></td>
                        </tr>
                        <tr>
                            <td>DeviceID:</td>
                            <td><input type="number" name="deviceid"></td>
                        </tr>
                        <tr>
                            <td>InvoiceID:</td>
                            <td><input type="number" name="invoiceid"></td>
                        </tr>
                        <tr>
                            <td>Date:</td>
                            <td><input type="text" name="date"></td>
                        </tr>
                        <tr>
                            <td>Count: </td>
                            <td><input type="number" name="count"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit"></td>
                        </tr>
                    </table>
                </form>
                <br>
                <div>
                    <span><a href="ViewOrder.jsp">ViewOrder</a></span>
                </div>
    </body>
</html>
