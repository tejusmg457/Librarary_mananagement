<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
     <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.Student" %>
     <%  ArrayList<Student> Studentdata = (ArrayList) session.getAttribute("studentData"); %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Student</title>
</head>
<body>
 <br>
 <center>
        <table>
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>First Name</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Last Name</b></th>   
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Register No</b></th>    
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Semester</b></th>     
            

            <%int noofrow = Studentdata.size(), rowcount=0; %>
            
               <h2 style="color: teal;">Number of Students are :: <%= noofrow %><h2>
            <% for( rowcount=0; rowcount<noofrow; rowcount++) {
	            int rowNo = rowcount;
	            Student stddata = (Student)Studentdata.get(rowNo);  
            %>
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
            
              <td><%= stddata.getSFirstName() %></td>
              <td><%= stddata.getSLatstName() %></td>
              <td><%= stddata.getSRegNo() %></td>
              <td><%= stddata.getSSem() %></td> 

            </tr>
            <% } %>
        </table>
    </center>

  <br><a href="../JspPages/libDashboard.jsp"><button style="color:black; background-color:white;"><b>Dashboard<b></button></a> 
</body>
</html>