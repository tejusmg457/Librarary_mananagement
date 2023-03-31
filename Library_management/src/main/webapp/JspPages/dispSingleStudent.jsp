<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.Student" %>
     <%  Student stddata = (Student) session.getAttribute("studentData"); %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Student</title>
</head>
<body>
 
 <br>
<h2>Details of Student :: <%= stddata.getSRegNo() %></h2>
 <center>
        <table>
        	
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>First Name</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Last Name</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>RegNo.</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Semester</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Department</b></th>
                
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
              <td><%= stddata.getSFirstName() %></td>
              <td><%= stddata.getSLatstName() %></td>
              <td><%= stddata.getSRegNo()%></td>
              <td><%= stddata.getSSem()%></td>
              <td><%= stddata.getSDep() %></td> 
            </tr>
        </table>
        <br><a href="../JspPages/libDashboard.jsp"><button >Dashboard</button></a> 
    </center>
</body>
</html>