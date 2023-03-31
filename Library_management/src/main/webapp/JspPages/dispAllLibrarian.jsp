<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.Librarian" %>
     <%  ArrayList<Librarian> libdata = (ArrayList) session.getAttribute("Libdata"); %>
     
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
        	<th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Librarian ID</b></th>
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>First Name</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Last Name</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Password</b></th>
			<%int noofrow = libdata.size(), rowcount=0; %>
			
			
			<h1>Number of rows available is :: <%= noofrow %><h1>
			
            <% for(rowcount=0; rowcount <noofrow; rowcount++){%>
            
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
            
               <% Librarian librariandata = (Librarian)libdata.get(rowcount); %>
              <td><%= librariandata.getLibID() %> </td>
              <td><%= librariandata.getLibFirstName() %></td>
              <td><%=  librariandata.getLibLastName() %></td>
              <td><%=  librariandata.getLpassword() %></td> 
            </tr>
            <% } %>
         
        </table>
    </center>
	 <br><a href="../JspPages/adminDashboard.jsp"><button ><b>Dashboard<b></button></a> 
</body>
</html>