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
        <title>IoTBay Admin - View/Search Staff List</title>
    </head>
    <body>
        <div>
            IotBay Admin - View/Search/Modify/Delete Staff information
        </div>
        <%
            ArrayList<Staff> resultArr = (ArrayList<Staff>) session.getAttribute("resultArr");
            String notFoundErr = (String) session.getAttribute("notFoundErr");
        %>
        <div>
            <table>
                <tr>
                    <td>
                        <!-- 
                        This form is used to view a list of all staff. The DAO for searching
                        staff members based on part of their name and role will fetch all
                        staff members if the search parameter is an empty string. This
                        allows reusage of the function and avoids code redundancy.
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
                        This form is used to search staff based on part of their name
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
                if (resultArr != null) {
                
            %>
            <div> Results found, put table here </div>
            <% } %>
            
        </div>
    </body>
</html>
