<%-- 
    Document   : createStaff
    Created on : 11/05/2021, 7:10:26 PM
    Author     : TED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Admin - Create Staff User</title>
    </head>
    
    <body>
        <div>
            <span>IoTBay Admin <a href="adminView.jsp">Admin Home</a> <a href="logout.jsp">Logout</a></span>
        </div>
        <div>IotBay Admin - Create New Staff</div>
        
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String existErr = (String) session.getAttribute("existErr");
        %>
        
        <form action="CreateStaffController" method="POST">
            <table>
                <tr>
                    <div>
                        <%= emailErr != null ? emailErr : "" %><br>
                        <%= passErr != null ? passErr : "" %><br>
                        <%= existErr != null ? existErr : "" %><br>
                    </div>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" id="dob" name="dob"/></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="tel" id="phone" name="phone"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" id="address" name="address"></td>
                </tr>    
                <tr>
                    <td><input type="submit" value="Sign Up"></td>
                </tr>
            </table>
        </form>   
    </body>
</html>
