<%--
    Document   : login
    Author     : TED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Login Page</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="index.jsp">Home</a><a href="register.jsp">Register</a></span>
        </div>
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String existErr = (String) session.getAttribute("existErr");
            String disableErr = (String) session.getAttribute("disableErr");
        %>
        <form action="LoginController" method="POST">
            <!-- need to differentiate data from login and register when they
            are posted to welcome page since there is no database yet -->
            <table>
                <tr>
                    <div>
                        <%= emailErr != null ? emailErr : "" %><br>
                        <%= passErr != null ? passErr : "" %><br>
                        <%= existErr != null ? existErr : "" %><br>
                        <%= disableErr != null ? disableErr : "" %><br>
                    </div>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <td>Role</td>
                    <td>
                        <select class="select" name="Role">
                            <option value="Customer">Customer</option>
                            <option value="Staff">Staff</option>
                            <option value="Admin">Admin</option>                                                                
                        </select>
                    </td>
                <tr>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
