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
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                  <tr>
                    <td>Placeholder ID</td>
                    <td>Placeholder Name</td>
                    <td>Placeholder Stock</td>
                  </tr>
                </table>

                <h2>Order</h2>
                <form action="OrderController.java" method="POST">
                    <table>
                        <tr>
                            <td>ProductID:</td>
                            <td><input type="productid" id="productid" name="productid"></td>
                        </tr>
                        <tr>
                            <td>Count:</td>
                            <td><input type="Count" id="Count" name="Count"></td>
                        </tr>
                        <tr>
                            <td><input type="button" id="add" value="add"></td>
                        </tr>
                    </table>
                </form>
                
    </body>
</html>
