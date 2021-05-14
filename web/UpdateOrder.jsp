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
        <form action="ViewOrderController" method="POST">
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

            int orderid = detailedorder.getOrderID();
            session.setAttribute("orderid", orderid);
            int deviceid = detailedorder.getDeviceID();
            session.setAttribute("deviceid", deviceid);
            int countp = detailedorder.getCount();
            session.setAttribute("countp", countp);
            String notint = (String) session.getAttribute("notint");
                 %>
                 
                    <h2>Update order:<%=detailedorder.getOrderID()%></h2>
                    <table>
                        
                        <tr>
                            <td>count:</td>
                            <td><input type="number" name="count"></td>
                        </tr>
 
                        <tr>
                            <td><input type="submit" value="Submit"></td>
                        </tr>
                    </table>
                    <br>
                    <%=notint!=null ? notint : ""%>
                </form>
    </body>
</html>
