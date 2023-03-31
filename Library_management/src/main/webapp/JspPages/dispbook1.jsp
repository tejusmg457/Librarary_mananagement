<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.*" %>
     <%  Book bookdataId = (Book) session.getAttribute("bookdataid"); %>
     <%  Book bookdataname = (Book) session.getAttribute("bookdataname"); %>
     <%  Book bookdataauthor = (Book) session.getAttribute("bookdataauthor"); %>
      <% boolean id = bookdataId==null ;%>
      <% boolean name = bookdataname==null ;%>
      <% boolean author = bookdataauthor==null ;%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display librarian</title>
</head>
<body>
 <br>
 <center>
 	<table>	
	 <% if ( id == false) { %>
		 	<h3 style=" color: green;">Details of book for the given ID :: <%= bookdataId.getBookId()%></h3>
	 		
	 		<th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book ID</b></th>
		    <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book Name</b></th>
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book Department</b></th>            
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book author</b></th>
	 		
	 		<tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
	 			<td> <%= bookdataId.getBookId()%> </td>
	             <td> <%= bookdataId.getBookName()%> </td>
	             <td> <%= bookdataId.getBookDepartment()%> </td>
	             <td> <%= bookdataId.getBookAuthor()%> </td>
             </tr>
      <table>
      <%  id = true; %>	
      
 	<% } %>
 	<% if ( author == false ) { %>
		 	<h3 style=" color: green;">Details of book for the given Author :: <%= bookdataauthor.getBookAuthor()%> </h3>
	 		
	 		<th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book ID</b></th>
		    <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book Name</b></th>
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book Department</b></th>            
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book author</b></th>
	 		
	 		<tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
	 			<td> <%= bookdataauthor.getBookId()%> </td>
	             <td> <%= bookdataauthor.getBookName()%> </td>
	             <td> <%= bookdataauthor.getBookDepartment()%> </td>
	             <td> <%= bookdataauthor.getBookAuthor()%> </td>
             </tr>
        <table>	
         <%  author = true; %>
 	<% } %>
 	<% if ( name == false) { %>
		 	<h3 style=" color: green;">Details of book for the given Name :: <%= bookdataname.getBookName()%> </h3>
	 		
	 		<th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book ID</b></th>
		    <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book Name</b></th>
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book Department</b></th>            
		    <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book author</b></th>
	 		
	 		<tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
	 			<td> <%= bookdataname.getBookId()%> </td>
	             <td> <%= bookdataname.getBookName()%> </td>
	             <td> <%= bookdataname.getBookDepartment()%> </td>
	             <td> <%= bookdataname.getBookAuthor()%> </td>
             </tr>
        <table>	
         <%  name = true; %>
 	<% } %>
      </table>
    </center>
    <br><br>
    <a href="./libDashboard.jsp"><button><b>Dashboard</b></button></a>
    <a href="./searchBook.jsp"><button><b>Search book</b></button></a>
</body>
</html>