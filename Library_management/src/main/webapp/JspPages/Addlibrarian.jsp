<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="./header.jsp" %>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add librarian</title>
</head>
<body style="background-color: lightblue; ">
    <div style="text-align:center; height: 280px; width: 412px; background-color: lightcyan; margin-top: 6%; margin-left: 36%; border-radius: 30px;">
        <br><h3 style="color: forestgreen;">Please enter the details here!</h3>

        <form action="../Controller/addLibrarian" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
            <tr>
                <td>First name:</td><td><input type="text" name="lfname" placeholder="Enter first name"></td>
            </tr>
            <tr>
                <td>last name:</td><td><input type="text" name="llname" placeholder="Enter last name"></td>
            </tr>
            <tr>
                <td>Employee id:</td><td><input type="text" name="lid" placeholder="Enter employee id"></td>
            </tr>
            <tr>
                <td>Password:</td><td><input type="password" name="lpassword" placeholder="Enter password"></td> 
            </tr>
        </table> 
        <br><button><b>Add librarian</b></button>
        </center>
    	</form>
    	 <br><a href="../JspPages/adminDashboard.jsp"><button ><b>Dashboard<b></button></a> 
 	</div>
 	 
 </body>
 </html>