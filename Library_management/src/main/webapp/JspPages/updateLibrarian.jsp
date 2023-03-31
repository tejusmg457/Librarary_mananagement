<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="./header.jsp" %>
  <%@ page import="in.ineuron.dto.Librarian" %>
  <%  Librarian libdata = (Librarian) session.getAttribute("Libdata"); %>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update librarian</title>
</head>
<body style="background-color: lightblue; ">
<% if(libdata!=null) { %>
    <div style="text-align:center; height: 230px; width: 412px; background-color: lightcyan; margin-top: 7%; margin-left: 36%; border-radius: 30px;">
        <br><h3 style="color: forestgreen;">Please enter the correct details!</h3>

        <form action="../Controller/updateLibrarian" method="post">
        <center>
        <table style="border-radius: 1px; text-align: left; text-shadow: 1;">
        	<tr>
                <td>Employee id:</td><td><input type="hidden" name="lid" value= "<%= libdata.getLibID() %>" ></td>
            </tr>
            <tr>
                <td>First name:</td><td><input type="text" name="lfname" value= "<%= libdata.getLibFirstName() %>" ></td>
            </tr>
            <tr>
                <td>last name:</td><td><input type="text" name="llname" value=  "<%= libdata.getLibLastName() %>" ></td>
            </tr>
            <tr>
                <td>Password:</td><td><input type="password" name="lpassword" value=  "<%= libdata.getLpassword() %>"  ></td> 
            </tr>
        </table> 
        <br><button><b>Update librarian</b></button>
        </center>
    	</form>
 	</div>
 <% } %>
 </body>
 </html>