<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard-librarian</title>
</head>
<body style="background-color: bisque;">
<br/>
    <h1 style="text-align: center; color: firebrick;">Librarian Dashboard</h1>
    
    <div style="background-color: lightcyan; height: 310px; width: 640px; border-radius: 50px; margin-top: 2%; margin-left: 30%; text-align: center;">
    
    <br/>
        <h2 style="color: black; text-align: center;"><b>Select your option</b></h2>
        
        <table>
		        <tr>
		        	<a href="../JspPages/addStudent.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:5px;"><b>Register student</b></button></a>
      			    <a href="../JspPages/searchStudent.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Search student</b></button></a>
        			 <form action="../Controller/studentList" method="post"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Student <br> list</b></button></a></form>
        			<a href="../JspPages/deleteStudent.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Delete student</b></button></a>
        			<a href="../JspPages/getStudent.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Update student</b></button></a>
		        </tr>
		        <br>
		        <tr>
		        	<a href="../JspPages/addBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px; margin-top: 20px;"><b>Add <br> book</b></button></a>
        			<a href="../JspPages/issueBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px; margin-top: 20px;"><b>Issue <br> book</b></button></a>
        			<a href="../JspPages/searchBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px; margin-top: 20px;"><b>Search <br> book</b></button></a>
        			<a href="../JspPages/deleteBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px; margin-top: 20px;"><b>Delete <br> book</b></button></a>
		        </tr>
		        <tr>
		        	<a href="../JspPages/getBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Update <br> book</b></button></a><br/><br/>
        			<a href="../JspPages/getReturnBook.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Return <br> book</b></button></a>
        			<a href="../Welcome.jsp"><button style="height: 50px; width: 100px; border-radius: 15px; background-color: lightgreen; margin-left:15px;"><b>Log <br> out</b></button></a> 
		        </tr>
        
        
        </table>
       
    </div>
</body>
</html>       