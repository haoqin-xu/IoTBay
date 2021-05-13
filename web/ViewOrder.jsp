<%-- 
    Document   : ViewOrder
    Created on : 07/05/2021, 1:04:36 PM
    Author     : Alec
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a></span>
        </div>
        <form action ="ListOrderController" method ="POST">
             <tr>
                <td>CustomerID:</td>
                <td><input type="number" name="customerid"></td>
             </tr>
             <tr>
                <td><input type="submit" value="Submit"></td>
             </tr>
        <%
            
            ArrayList<Order> orderlist = (ArrayList<Order>)session.getAttribute("orderlist");
            
        %>
        <table id="Orderlist">
            <h2>List of orders</h2>
            <tr>
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Payment ID</th>
                <th>Device ID</th>
                <th>Status</th>
                <th>Invoice ID</th>
                <th>Date</th>
            </tr>
            <%if(orderlist!=null){
                for(Order element : orderlist){%>
            <tr>
                <th><%=element.getOrderID()%></th>
                <th><%=element.getCustomerID()%></th>
                <th><%=element.getPaymentID()%></th>
                <th><%=element.getDeviceID()%></th>
                <th><%=element.getStatus()%></th>
                <th><%=element.getInvoiceID()%></th>
                <th><%=element.getDate()%></th>
            </tr>
            
            <%}}%>
            
        </table>
        </form>
            <br>
            <br>
            
            <form action ="ViewOrderController" method ="POST">
                <tr>
                            <td>Enter orderid to update:</td>
                            <td><input type="number" name="orderid"></td>
             </tr>
             <tr>
                            <td><input type="submit" value="Submit"></td>
             </tr>
            </form>
            <form action ="DeleteOrderController" method ="POST">
                <tr>
                            <td>Enter orderid to delete:</td>
                            <td><input type="number" name="orderid"></td>
             </tr>
             <tr>
                            <td><input type="submit" value="Submit"></td>
             </tr>
            </form>  
    </body>
</html>
