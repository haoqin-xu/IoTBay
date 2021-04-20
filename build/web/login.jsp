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
        
        <form action="welcome.jsp" method="POST">
            <input type="hidden" id="tos" name="tos" value="login"> 
            <!-- need to differentiate data from login and register when they 
            are posted to welcome page since there is no database yet -->
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
