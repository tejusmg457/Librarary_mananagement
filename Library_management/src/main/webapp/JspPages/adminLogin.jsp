<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
</head>
<body style="background-color: bisque; text-align: center; "> 

<%@ include file="./header.jsp" %>

    <div style="background-color: skyblue; height:200px; width: 400px; border-radius: 50px; margin-top:8%; margin-left: 555px; margin-right: 500px;">
        <br>
        <h2 style="color: green;"><b><u>Admin login</u></b></h2>
        <form action="../Controller/adminLogin" method="post">
            <center>
                <table style="border-radius: 1px; text-align: left;">
                    <tr>
                        <td>Admin ID:</td><td><input type="text" name="adminid" placeholder="Enter ID" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td><td><input type="password" name="adminpw" placeholder="Enter Password" /></td>
                    </tr>
                </table>
            </center>
            <br>
            <button style="text-align: center;"><b>Log in<b></button>
        </form>
    </div>
</body>
</html>