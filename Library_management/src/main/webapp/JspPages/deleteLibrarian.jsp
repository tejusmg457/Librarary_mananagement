<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="./header.jsp" %>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>delete librarian</title>
</head>
<body style="background-color: lightblue; ">
    <div style="text-align:center; height: 230px; width: 412px; background-color: lightcyan; margin-top: 8%; margin-left: 36%; border-radius: 30px;">
        <br><h2 style="color: forestgreen;">Search Librarian</h2>
        <form action="../Controller/deleteLibrarian" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
            <tr>
                <td>Librarian id:</td><td><input type="text" name="lid" placeholder="Enter librarian id"></td>
            </tr>
        </table> 
        <br><button><b>Delete</b></button>
        </center>
    	</form>
    	 <br><a href="../JspPages/adminDashboard.jsp"><button ><b>Dashboard<b></button></a> 
 	</div>
 </body>
 </html>