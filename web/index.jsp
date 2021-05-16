<%-- 
    Document   : index
    Author     : Hao-qin Xu
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/mainstyle.css">
        <title>IoTBay - Home Page</title>
    </head>
    <body>
            <div class="topnav"><div class="htop">IoTBay</div><a href="login.jsp">Login</a> <a href="register.jsp">Register</a><a href="index.jsp">Home</a><a href="CreateOrder.jsp">Create Order</a><a href="ViewOrder.jsp">View Order</a></div>
            <br>

                <%
                    //set date for order:
                    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    //set anonymous customer
                    session.setAttribute("randompaymentid",0);
                    session.setAttribute("date", date);
                %>
                <% if (session.getAttribute("user") == null) { 
                    // if there are no users logged in 
                    Customer anonymous = new Customer(0,"anonymous","anonymous","anonymous","anonymous","anonymous","anonymous","anonymous");
                    session.setAttribute("user",anonymous);
                    
                %>
                    <span>You are not logged in. <a href="login.jsp">Login</a> <a href="register.jsp">Register</a></span>
                <% } else { // display user info if they are logged in
                    Customer user = (Customer) session.getAttribute("user");
                %>
                    <span>You are logged in as ${user.name} &lt;${user.email}&gt; <a href="profile.jsp">Profile</a> <a href="logout.jsp">Logout</a></span>
                <% } %>
                
                <a href="paycreate.jsp">Test 04 Payment</a>
            </div>
        </div>
        
        <div>
            
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
