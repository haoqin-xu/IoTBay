<%-- 
    Document   : CreateOrder
    Created on : 07/05/2021, 1:04:18 PM
    Author     : Alec
--%>

<%@page import="uts.isd.model.Device"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/mainstyle.css">
        <title>Create order</title>
    </head>
    <body>
        <div>
            <div class="topnav"><div class="htop">IoTBay</div><a href="ViewOrder.jsp">View Order</a><a href="index.jsp">Home</a></div>
            
        </div>

        <br>

                <form action ="ListDeviceController" method ="POST">
             <tr>
                <td><input type="submit" value="View order list"></td>
             </tr>
        <%
            
            ArrayList<Device> devicelist = (ArrayList<Device>)session.getAttribute("devicelist");
            
        %>
        <table id="Orderlist">
            <h2>List of Devices</h2>
            <tr>
                <th>Device ID</th>
                <th>Name</th>
                <th>Manufacturer</th>
                <th>Origin</th>
                <th>Type</th>
                <th>Instock</th>
                <th>priceperunit</th>
                <th>numberinstock</th>
            </tr>
            <%if(devicelist!=null){
                for(Device element : devicelist){%>
            <tr>
                <th><%=element.getDeviceid()%></th>
                <th><%=element.getName()%></th>
                <th><%=element.getManufacturer()%></th>
                <th><%=element.getOrigin()%></th>
                <th><%=element.getType()%></th>
                <th><%=element.getInstock()%></th>
                <th><%=element.getPriceperunit()%></th>
                <th><%=element.getNumberinstock()%></th>
            </tr>
            
            <%}}%>
            
        </table>
        </form>

                <h2>Order</h2>
                <form action="OrderController" method="POST">
                    <%
                        Random rand = new Random();
                        int invoiceid = rand.nextInt(999);
                        session.setAttribute("invoiceid",invoiceid);
                        String outoflist = (String) session.getAttribute("outoflist");
                        String notint = (String) session.getAttribute("notint");
                        String success = (String) session.getAttribute("successful");
                    %>
                    <table>
                        <tr>
                            <td>DeviceID:</td>
                            <td><input type="number" name="deviceid"></td>
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
               
               
                <div>
                    <%=success!=null ? success : ""%>
                    <%=outoflist!=null ? outoflist : ""%>
                    <%=notint!=null ? notint : ""%>
                </div>
    </body>
</html>
