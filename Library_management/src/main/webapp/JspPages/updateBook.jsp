<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="./header.jsp" %>
  <%@ page import="in.ineuron.dto.Book" %>
  <%  Book bookdata = (Book) session.getAttribute("bookdata"); %>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Book</title>
</head>
<body style="background-color: lightblue; ">
    <div style="text-align:center; height: 230px; width: 412px; background-color: lightcyan; margin-top: 8%; margin-left: 36%; border-radius: 30px;">
        <br><h3 style="color: forestgreen;">Please enter the correct details!</h3>

        <form action="../Controller/updateBook" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
        	<tr>
                <td>Book id:</td><td><input type="hidden" name="bid" value= "<%= bookdata.getBookId() %>" ></td>
            </tr>
            <tr>
                <td>Book name:</td><td><input type="text" name="bname" value= "<%= bookdata.getBookName() %>" ></td>
            </tr>
            <tr>
                <td>Book department:</td><td><input type="text" name="bdep" value=  "<%= bookdata.getBookDepartment() %>" ></td>
            </tr>
            <tr>
                <td>Book Author:</td><td><input type="text" name="bauthor" value=  "<%= bookdata.getBookAuthor() %>"  ></td> 
            </tr>
        </table> 
        <br><button><b>Update</b></button>
        </center>
    	</form>
 	</div>
 </body>
 </html>