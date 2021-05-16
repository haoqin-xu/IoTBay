<%-- 
    Document   : viewStaff
    Created on : 11/05/2021, 7:09:47 PM
    Author     : TED
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Admin - Staff List</title>
    </head>
    
    <body>
        <div>
            <span>IoTBay Admin <a href="adminView.jsp">Home</a> <a href="logout.jsp">Logout</a></span>
        </div>
        <div>IotBay Admin - View/Search/Modify/Delete Staff information</div>
        
        <%
            ArrayList<Staff> resultArr = (ArrayList<Staff>) session.getAttribute("resultArr");
            String notFoundErr = (String) session.getAttribute("notFoundErr");
            String deleteResult = (String) session.getAttribute("deleteResult");
        %>
        <div>
            <table>
                <tr>
                    <td>
                        <!-- 
                        This form is used to view a list of all staff. The DAO 
                        for searching staff members based on part of their name 
                        and role will fetch all staff members if the search 
                        parameter is an empty string. This allows reusage of the 
                        function and avoids code redundancy.
                        
                        The empty value field ensures that the value that is
                        sent to the DAO is an empty string. 
                        -->
                        <form action="ViewStaffController" method="POST">
                            <input type="hidden" id="name" name="name" value="">
                            <input type="hidden" id="role" name="role" value="">
                            <input type="submit" value="View All Staff">
                        </form>

                    </td>
                </tr>

                <tr>
                    <td>
                        Search staff based on part of name and role (leave fields empty to not use that parameter for the search)
                    </td>
                </tr>
                <tr>
                    <td>
                        <!-- 
                        This form is used to search staff based on part of their 
                        name and role using the % wildcard. Users can leave 
                        either of the fields blank if they do not wish to use
                        it to filter results during the query.
                        -->
                        <form action="ViewStaffController" method="POST">
                            Name:
                            <input type="text" id="name" name="name" value="">
                            Role:
                            <input type="text" id="role" name="role" value="">
                            <input type="submit" value="Search">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
        
        <div>
            <!-- the results of fetching staff is shown here!-->
            <%= notFoundErr != null ? notFoundErr : "" %>
            <%
            if (resultArr != null) { // if the search returns at least 1 staff user 
                System.out.println(resultArr);
            %>
                <table id="staffSearchResult">
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Date of Birth</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Role</th>
                        <th></th>
                        <th></th>
                    </tr>
                <% for (Staff s : resultArr) { %>
                    <tr>
                        <td><%= s.getID()%></td>
                        <td><%= s.getEmail()%></td>
                        <td><%= s.getName()%></td>
                        <td><%= s.getPassword()%></td>
                        <td><%= s.getDob()%></td>
                        <td><%= s.getPhone()%></td>
                        <td><%= s.getAddress()%></td>
                        <td><%= s.getRole()%></td>
                        <!-- 
                            This form POSTs the ID of the staff on this row of 
                            the table into the edit servlet. The doPost
                            function on the servlet handles the specified value
                            and loads the staff object into the editing page
                        -->
                        <th>
                            <form action="EditStaffController" method="POST">
                                <input type="hidden" name="staemail" id="staemail" value="<%= s.getEmail()%>">
                                <input type="hidden" name="stapassword" id="stapassword" value="<%= s.getPassword()%>">
                                <input type="submit" value="Edit">
                            </form>
                        </th>
                        <!-- 
                            This form POSTs the ID of the staff on this row of 
                            the table into the delete servlet. The doPost
                            function on the servlet handles the specified value
                            and attempts to delete the user.
                        -->
                        <th>
                            <form action="DeleteStaffController" method="POST">
                                <input type="hidden" name="staid" id="staid" value="<%= s.getID()%>">
                                <input type="submit" value="Delete">
                            </form>
                        </th>
                    </tr>
                <% } %>
                </table>
            <% } %>
            <!-- the results of deleting a staff is shown here!-->
            <br>
            <%= deleteResult != null ? deleteResult : "" %>
        </div>
    </body>
</html>
