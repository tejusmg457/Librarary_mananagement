<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./header.jsp" %>
     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Librarian login</title>
</head>
<body style="background-color: bisque; text-align: center; "> 
    <div style="background-color: skyblue; height:250px; width: 400px; border-radius: 50px; margin-top:8%; margin-left: 550px; margin-right: auto;">
        <br>
        <h2 style="color: green;"><b><u>Librarian login</u></b></h2>
        <form action="../Controller/librarianLogin" method="post">
            <center>
                <table style="border-radius: 1px; text-align: left;">
                    <tr>
                        <td>Employee ID:</td><td><input type="text" name="lid" placeholder="Enter employee ID" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td><td><input type="password" name="lpw" placeholder="Enter Password" /></td>
                    </tr>
                </table>
            </center>
            <br>
            <button style="text-align: center;"><b>Log in</button><b><br><br>
            <a href="./forgotLibPassword.jsp"><b>Forgott passwod<b></a>
        </form>
    </div>
</body>
</html>