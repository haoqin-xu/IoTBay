<%-- 
    Document   : index
    Author     : Hao-qin Xu
--%>

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
                <% if (session.getAttribute("user") == null) { // if there are no users logged in %>
                    <span>You are not logged in. <a href="login.jsp">Login</a> <a href="register.jsp">Register</a></span>
                <% } else { // display user info if they are logged in
                    Customer user = (Customer) session.getAttribute("user");
                %>
                    <span>You are logged in as ${user.name} &lt;${user.email}&gt; <a href="profile.jsp">Profile</a> <a href="logout.jsp">Logout</a></span>
                <% } %>
            </div>
        </div>
        
        <div>Footer
            
        </div>
    </body>
</html>
