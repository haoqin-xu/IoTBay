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
        <div>IoTBay - Registration</div>
        <form action="welcome.jsp" method="POST">
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
                    <td>Agree to TOS:</td>
                    <td><input type="checkbox" id="tos" name="tos" value="yes"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Sign Up"></td>
                </tr>
            </table>
            
            
        </form>
    </body>
</html>
