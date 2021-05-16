<%-- 
    Document   : editStaff
    Created on : 16/05/2021, 12:36:49 PM
    Author     : TED
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Admin - Update Staff Details</title>
    </head>
    
    <body>
        <div>
            <span>IoTBay Admin <a href="adminView.jsp">Home</a> <a href="logout.jsp">Logout</a></span>
        </div>
        <div>IotBay Admin - Edit Staff Information</div>
        
        <%
            Staff staff = (Staff) session.getAttribute("statoedit");
            if (staff != null) {
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String role = request.getParameter("role");
            }
        %>
        
        <%
            // check which page this is posted from, and display appropriate messages
        %>
        
        <form action="account.jsp" method="POST">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" id="email" name="email" value="<%= (email!=null)? email: user.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="name" name="name" value="<%= name%>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password" value="<%= password%>"></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" id="password" name="password" value="<%= dob%>"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="tel" id="phone" name="phone" value="<%= phone%>"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" id="address" name="address"value="<%= address%>"></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><input type="text" id="role" name="role"value="<%= role%>"></td>
                </tr>  
                <tr>
                    <td><input type="submit" value="Apply Changes"></td>
                </tr>
            </table>
        </form>
        
        <!-- Navigation to go back to the staff list view -->
        <form action="ViewStaffController" method="GET">
                <input type="submit" value="Back To Staff List">
        </form>
        
    </body>
</html>
