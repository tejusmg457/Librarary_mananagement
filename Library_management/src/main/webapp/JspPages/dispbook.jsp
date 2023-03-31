<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.*" %>
     <%  ArrayList<Book> bookdata = (ArrayList<Book>) session.getAttribute("bookdata"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Book</title>
</head>
<body>
 <br>
 <center>
 		<table>
		       <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book ID</b></th>
		       <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book Name</b></th>
		       <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book Department</b></th>            
		       <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book author</b></th>     

			 <%int noofrow = bookdata.size(), rowcount; %>

			 <h1>No of books available :: <%= noofrow %></h1>
            <% for(rowcount=0; rowcount<noofrow; rowcount++) {%>
          
			 <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
             <% Book bookdetails = (Book) bookdata.get(rowcount); %>
             <td> <%= bookdetails.getBookId()%> </td>
             <td> <%= bookdetails.getBookName()%> </td>
             <td> <%= bookdetails.getBookDepartment()%> </td>
             <td> <%= bookdetails.getBookAuthor()%> </td>
            </tr>
       
            <% } %>
 		  </table>
    </center>
    <br><br>
     <a href="./libDashboard.jsp"><button><b>Dashboard</b></button></a>
    <a href="./searchBook.jsp"><button><b>Search book</b></button></a>
</body>
</html>