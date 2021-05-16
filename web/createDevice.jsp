<%-- 
    Document   : createDevice
    Created on : 10/05/2021, 2:50:41 PM
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Device</title>
    </head>
    <body>
        <h1>Create Device</h1>
        <span><a href="index.jsp">Home</a></span>
        
        <form action="DeviceController" method="POST">
            <table>
                <tr>
                    <td>Device Name</td><td><input type="text" name="deviceName"></td>
                </tr>
                <tr>
                    <td>Manufacturer</td><td><input type="text" name="manufacturer"</td>
                </tr>
                <tr>
                    <td>Origin</td><td><input type="text" name="origin"</td>
                </tr>
                <tr>
                    <td>Type</td><td><input type="text" name="type"></td>
                </tr>
                <tr>
                    <td>In Stock</td><td><input type="boolean" name="inStock"></td>
                </tr>
                <tr>
                    <td>Price per Unit</td><td><input type="number" name="pricePerUnit"</td>
                </tr>
                <tr>
                    <td>Stock Number</td><td><input type="number" name="stockNum"</td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" value="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
