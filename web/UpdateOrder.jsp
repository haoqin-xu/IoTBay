<%-- 
    Document   : UpdateOrder
    Created on : 07/05/2021, 1:07:14 PM
    Author     : Alec
--%>

<%@page import="uts.isd.model.OrderLineItem"%>
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
        <form action="ViewDetailedOrderController" method="POST">
            <%
                OrderLineItem detailedorder = (OrderLineItem)session.getAttribute("detailedorder");
            
                 %>
                 
                    <h2>Current Order</h2>
                    <table>
                        <tr>
                            <td>Order number:</td>
                            <td><%=detailedorder.getOrderID()%></td>
                        </tr>
                        <tr>
                            <td>DeviceID:</td>
                            <td><%=detailedorder.getDeviceID()%></td>
                        </tr>
                        <tr>
                            <td>Count:</td>
                            <td><%=detailedorder.getCount()%></td>
                        </tr>
                    </table>
                </form>
        <form action="UpdateOrderController" method="POST">
            <%
            int orderid = Integer.parseInt(request.getParameter("orderid"));
            session.setAttribute("orderid", orderid);
            
                 %>
                 
                    <h2>Update order: <%=orderid%></h2>
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
                            <td><input type="submit" value="Submit"></td>
                        </tr>
                    </table>
                </form>
    </body>
</html>
