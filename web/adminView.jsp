<%-- 
    Document   : adminView
    Created on : 11/05/2021, 7:10:38 PM
    Author     : TED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Admin - Home Page</title>
    </head>
    
    <body>
        <div>IoTBay Admin - Admin Management Portal</div>
        
        <div>
            <span>Header <a href="logout.jsp">Logout</a></span>
        </div>

        <div>
            <!-- A form is used here with a get request; this allows the view
            staff controller to handle the page being opened from the admin
            menu and immediately fetch a list of all staff upon the page
            being opened. -->
            <form action="ViewStaffController" method="GET">
                <input type="submit" value="View and Edit Staff List">
            </form>
            <form action="CreateStaffController" method="GET">
                <input type="submit" value="Create New Staff">
            </form>
        </div>

        <!-- init connservlet at admin home for testing purposes. 
        This will be removed for release -->
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
