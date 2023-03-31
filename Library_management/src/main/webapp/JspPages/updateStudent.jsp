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
 
  <div style="text-align:center; height: 280px; width: 412px; background-color: lightcyan; margin-top: 7%; margin-left: 36%; border-radius: 30px;">
        <br><h3 style="color: forestgreen;">Please enter the correct details!</h3>
 <form action="../Controller/updateStudent" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
        	<tr>
                <td>Register No:</td><td><input type="hidden" name="sreg" value= "<%= stddata.getSRegNo() %>" ></td>
            </tr>
            <tr>
                <td>First name:</td><td><input type="text" name="sfname" value= "<%= stddata.getSFirstName() %>" ></td>
            </tr>
            <tr>
                <td>last name:</td><td><input type="text" name="slname" value= "<%= stddata.getSLatstName() %>" ></td>
            </tr>
            <tr>
                <td>Semester:</td><td><input type="text" name="ssem" value= "<%= stddata.getSSem() %>" ></td>
            </tr>
            <tr>
                <td>Department:</td><td><input type="text" name="sdept" value= "<%= stddata.getSDep()%>" ></td>
            </tr>
 		</table> 
        <br><button><b>Update </br> Student</b></button>
        </center>
    	</form>
 	</div>
 </body>