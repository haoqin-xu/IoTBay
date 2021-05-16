<%-- 
    Document   : register
    Author     : TED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Registration</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a><a href="login.jsp">Login</a></span>
        </div>
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String successMsg = (String) session.getAttribute("successMsg");
        %>
        <div>IoTBay - Registration</div>
        <form action="RegisterController" method="POST">
            <table>
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
                    <td>Role:</td>
                    <td><input type="text" id="role" name="role"></td>
                </tr>  
                <tr>
                    <td><input type="submit" value="Create Staff User"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <%= emailErr != null ? emailErr : "" %>
                        <%= passErr != null ? passErr : "" %>
                        <%= successMsg != null ? successMsg : "" %>
                    </td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
