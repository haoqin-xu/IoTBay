<%-- 
    Document   : ViewOrderCustomer
    Created on : 10/05/2021, 11:27:19 AM
    Author     : Alec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="ListOrderController" method ="POST">
             <tr>
                            <td>CustomerID:</td>
                            <td><input type="number" name="customerid"></td>
             </tr>
             <tr>
                            <td><input type="submit" value="Submit"></td>
             </tr>
        </form>
    </body>
</html>
