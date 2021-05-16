<%-- 
    Document   : profile
    Author     : TED
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Edit Profile</title>
    </head>
    <body>
        <div>
            <span>IoTBay Customer <a href="index.jsp">Home</a> <a href="logout.jsp">Logout</a></span>
        </div>
        <%
            Customer customer = (Customer) session.getAttribute("statoedit");
            String id = request.getParameter("id");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String role = request.getParameter("role"); 
            String editResult = (String) session.getAttribute("editResult");
        %> 
            <%= editResult != null ? editResult : "" %>
        <form action="UpdateProfileController" method="POST">
            <input type="hidden" id="id" name="id" value="<%= (customer!=null)? customer.getID(): id%>">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" id="email" name="email" value="<%= (email!=null)? email: customer.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="name" name="name" value="<%= (name!=null)? name: customer.getName()%>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password" value="<%= (password!=null)? password: customer.getPassword()%>"></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" id="dob" name="dob" value="<%= (dob!=null)? dob: customer.getDob()%>"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="tel" id="phone" name="phone" value="<%= (phone!=null)? phone: customer.getPhone()%>"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" id="address" name="address"value="<%= (address!=null)? address: customer.getAddress()%>"></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><input type="text" id="role" name="role"value="<%= (role!=null)? role: customer.getRole()%>"></td>
                </tr>  
                <tr>
                    <td><input type="submit" value="Apply Changes"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
