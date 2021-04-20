<%-- 
    Document   : logout
    Author     : TED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Logged out</title>
    </head>
    <%
        session.invalidate(); // delete user info from session
    %>
    <body>
        <div>You have been logged out. Click <a href="index.jsp">here</a> to return to the main page.
    </body>
</html>
