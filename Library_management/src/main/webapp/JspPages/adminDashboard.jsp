<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="./header.jsp" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
</head>
<body style="text-align: center; background-color: bisque;">

    <div style="height: 230px; width: 500px; background-color: lightcyan; margin-top: 7%; margin-left: 33%; border-radius: 30px;">
        <br><h1 style="color: teal;">Admin Dashboard!</h1>
        <table>
            <tr>
                <td><a href="../JspPages/Addlibrarian.jsp"><button style="height: 45px; width: 80px; margin-left: 85px; border-radius: 10px;"><b>Add librarian</b></button></a></td>
                <td><a href="../JspPages/getLibrarian.jsp"><button style="height: 45px; width: 80px; margin-left: 40px; border-radius: 10px;"><b>Update librarian</b></button></a></td>
                <td><a href="../JspPages/searchLibrarian.jsp"><button style="height: 45px; width: 80px; margin-left: 40px; border-radius: 10px;"><b>Search librarian</b></button></a></td>
             	
            </tr>
           <tr></tr><tr></tr><tr></tr><tr></tr>
            <tr>
            	<td><form action="../Controller/allLibrarianData" method="post"><button style="height: 45px; width: 80px; margin-left: 85px; border-radius: 10px;"><b>librarian details</b></button></form></td>
            	<td><a href="../JspPages/deleteLibrarian.jsp"><button style="height: 45px; width: 80px; margin-left: 40px; border-radius: 10px;"><b>Delete librarian</b></button></a></td>
                <td><a href="../Welcome.jsp"><button style="height: 45px; width: 80px; margin-left: 40px; border-radius: 10px;"><b>Logout</b></button></a></td>
            </tr>
        </table>

    </div>
</body>
</html>