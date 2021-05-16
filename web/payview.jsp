<%-- 
    Document   : paymentread
    Created on : 05/05/2021, 5:14:03 PM
    Author     : Briana Margetts
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/mainstyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Payment read Page</title>
    </head>
    <body> 
        <div>
            <div class="topnav"><div class="htop">IoTBay</div><a href="paycreate.jsp">Add Payment Method</a><a href="logout.jsp">Logout</a><a href="index.jsp">Home</a></div>
        </div>
        <!--customer can view their saved payment details-->
        <h1>Your saved payment details</h1>
        <%
            String paymenttype = request.getParameter("paymenttype");
            String accountnumber = request.getParameter("accountnumber");
            String ccv = request.getParameter("ccv");
            String paymentmethodErr = (String) session.getAttribute("paymentmethodErr");
            String accountnumberErr = (String) session.getAttribute("accountnumberErr");
            String ccvErr = (String) session.getAttribute("ccvErr");
            String deleteErr = (String) session.getAttribute("deleteErr");
        %>
        </br>
        <form action="payupdate.jsp" method="post" method="get">
            <table id="paymentdetail">
                <tr>
                    <th>Payment Method</th>
                    <td><%=(paymentmethodErr != null ? paymentmethodErr : paymenttype)%>

                    </td>
                </tr>
                <th>Account Number</th>
                <td><%=(accountnumberErr != null ? accountnumberErr : accountnumber)%>
                </td>
                </tr>
                <tr>
                    <th>CCV Number</th>
                    <td><%=(ccvErr != null ? ccvErr : ccv)%>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>    
            </table>


        </form> 
        <!--customer can delete their payment details based on account number-->       
        <h1>Delete your payment details</h1>

        <form action="DeletePaymentMethod" method="POST"> 
            <td>Enter Account Number to be deleted:</td>
            <td><input type="number" id="accountnumber" name="accountnumber"></td>
            <input type="submit" value="Delete">
        </form>
        <div> <%= deleteErr != null ? deleteErr : ""%>
        </div>

        <br>
        <!-- customer can update their details based on account number-->
        <h1>Update your payment details</h1>
        <form action="UpdatePaymentMethod" method="POST"> 
            <td>Enter Account Number to be updated</td>
            <td><input type="number" id="accountnumber" name="accountnumber"></td>
            <input type="submit" value="Update">
        </form>
        <div> 
        </div>

        <br>


        <h1>Payment History</h1> 

        <form action="PaymentManager" method="POST">
            <table id="idSearch">
                <tr>
                    <td><input type="text" placeholder="Search by ID..."></td>
                    <td><input type="submit" value="Search"></td>
                </tr>
            </table>
        </form>

        <form action="PaymentManager" method="POST">
            <table id="dateSearch">
                <tr>
                    <td><input type="text" placeholder="Search by Date..."></td>
                    <td><input type="submit" value="Search"></td>
                </tr>
            </table>
        </form>



        <br>
        <table id="paymentdetail">
            <tr>
                <th>Payment ID</th>
                <th>Date</th>
                <th>Payment Method</th>
                <th>Account Number</th>
                <th>CCV Number</th>

            </tr>
            <!-- an array list of customers previous payment methods-->

            <% //for(int i=0; i<5; i++){%>
            <!-- for loop here -->
            <tr>
                <td>${payment.customerID}</td>         
                <td>${payment.date}</td>         
                <td>${payment.paymentmethod}</td>         
                <td>${payment.accountnumber}</td>         
                <td>${payment.ccv}</td>      
            </tr>
            <%//}%>
        </table>
    </body>
</html>
