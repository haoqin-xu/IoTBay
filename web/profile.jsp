<%-- 
    Document   : profile
    Author     : TED
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - My Profile</title>
    </head>
    <body>
        <span>IoTBay <a href="index.jsp">Home</a> <!--a href="account.jsp">Edit Account</a--> <a href="logout.jsp">Logout</a></span>
        <%
            User user = (User) session.getAttribute("user"); // getAttribute returns Object, not User. Need to be casted to type User
        %>
        <table id="users">
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
                <th>Date of Birth</th>
                <th>Phone</th>
                <th>Address</th>
            </tr>
            <tr>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.dob}</td>
                <td>${user.phone}</td>
                <td>${user.address}</td>
            </tr>
        </table>
        
                
        <div>Footer
            
        </div>
    </body>
</html>
