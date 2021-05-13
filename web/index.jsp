<%-- 
    Document   : index
    Author     : Hao-qin Xu
--%>

<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="lab/css/index.css">
        <title>IoTBay - Home Page</title>
    </head>
    <body>
        <div>IoTBay
            <div>
                <%
                    //set anonymous customer
                    Random rand = new Random();
                    session.setAttribute("anonymouscustomer",rand.nextInt(1000));
                %>
                <% if (session.getAttribute("user") == null) { // if there are no users logged in %>
                    <span>You are not logged in. <a href="login.jsp">Login</a> <a href="register.jsp">Register</a></span>
                <% } else { // display user info if they are logged in
                    Customer user = (Customer) session.getAttribute("user");
                %>
                    <span>You are logged in as ${user.name} &lt;${user.email}&gt; <a href="profile.jsp">Profile</a> <a href="logout.jsp">Logout</a></span>
                <% } %>
                <a href="CreateOrViewOrder.jsp">Create Or View Order</a>
                <a href="paycreate.jsp">Test 04 Payment</a>
            </div>
        </div>
        
        <div>
            
        </div>
            <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
