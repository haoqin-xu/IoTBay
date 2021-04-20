<%-- 
    Document   : welcome
    Author     : TED
--%>

<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Welcome</title>
    </head>
    <body>
        <% if (request.getParameter("tos") != null && request.getParameter("tos").equals("yes")) {
            // form was posted from the register.jsp page
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String phone = (String) request.getParameter("phone");
            String address = request.getParameter("address");
            %>
            <div>
                <span>IoTBay <a href="profile.jsp">Profile</a><a href="logout.jsp">Logout</a></span>
            </div>
            
            <div>Welcome, <%= name%>!</div>
            <div>Your Email is <%= email%>.</div>
            <div>Your password is <%= password%>.</div>
            <div>Your date of birth is <%= dob%>.</div>
            <div>Your phone number is <%= phone%>.</div>
            <div>Your address is <%= address%>.</div>
            <br>
            <div>Click <a href="index.jsp">here</a> to proceed to the main page</div>
            
            <%
                /*
                    Customer Object is stored to session here.
                */
                Customer user = new Customer(email, name, password, dob, phone, address);
                session.setAttribute("user", user); // save user object to session as "user"
            %>
        <% } else if (request.getParameter("tos") != null && request.getParameter("tos").equals("login")) {
            // form was posted from the login.jsp page.
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            %>
            <div>
                <span>IoTBay <a href="profile.jsp">Profile</a><a href="logout.jsp">Logout</a></span>
            </div>
            
            <div>Welcome back!</div>
            <div>Your Email is <%= email%>.</div>
            <div>Your password is <%= password%>.</div>
            <br>
            <div>Click <a href="index.jsp">here</a> to proceed to the main page</div>
            
        <% } else { %>
            <div>
                <span><a href="index.jsp">Home</a><a href="login.jsp">Login</a></span>
            </div>
            <div>Sorry, you must agree to the Terms of Service.</div><br>
            <div>Click <a href="register.jsp">here</a> to go back.</div>
            
        <% } %>
    </body>
</html>
