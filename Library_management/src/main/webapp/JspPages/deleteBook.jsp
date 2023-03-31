<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="./header.jsp" %>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>delete book</title>
</head>
<body style="background-color: lightblue; ">
    <div style="text-align:center; height: 220px; width: 412px; background-color: lightcyan; margin-top: 8%; margin-left: 36%; border-radius: 30px;">
        <br><h2 style="color: forestgreen;">Delete book</h2>
        <form action="../Controller/deleteBook" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
            <tr>
                <td>Book id:</td><td><input type="text" name="bookid" placeholder="Enter Book id"></td>
            </tr>
        </table> 
        <br><button><b>Delete</b></button>
        </center>
    	</form>
    	 <br><a href="../JspPages/libDashboard.jsp"><button >Dashboard</button></a> 
 	</div>
 </body>
 </html>