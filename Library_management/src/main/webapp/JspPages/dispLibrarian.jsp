<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.Librarian" %>
     <%  Librarian libdata = (Librarian) session.getAttribute("Libdata"); %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display librarian</title>
</head>
<body>
 
 <br>
<h2>Details of Librarian id :: <%= libdata.getLibID() %></h2>
 <center>
        <table>
        	<th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Librarian ID</b></th>
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>First Name</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Last Name</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Password</b></th>

            
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
              <td><%= libdata.getLibID() %></td><td><%= libdata.getLibFirstName()%></td><td><%= libdata.getLibLastName()%></td><td><%= libdata.getLpassword()%></td> 
            </tr>
        </table>
    </center>
 <br><a href="../JspPages/adminDashboard.jsp"><button ><b>Dashboard<b></button></a> 
</body>
</html>