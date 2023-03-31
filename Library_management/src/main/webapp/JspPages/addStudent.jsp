<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
</head>
<body style="text-align: center;">
<div style="text-align: center; height:330px; width:450px; background-color: skyblue; margin-top: 100px; margin-right: auto; margin-left: 540px; border-radius: 50px;">
    <br>
    <h2 style="color: green;"><b><u>Student registration form!</u></b></h2>
    <form action="../Controller/addStudent" method="post">
        <center>
            <table style="border-radius: 1px; text-align: left;">
                <tr>
                    <td>First name:</td><td><input type="text" name="sfname" placeholder="Enter first name" /></td>
                </tr>
                <tr>
                    <td>last name:</td><td><input type="text" name="slname" placeholder="Enter last name" /></td>
                </tr>
                <tr>
                    <td>Register No:</td></td><td><input type="text" name="sreg" placeholder="Enter Register no" /></td>
                </tr>
                <tr>
                    <td>Semester:</td><td><input type="text" name="ssem" placeholder="Enter Semester" /></td>
                </tr>
                    <td>Department:</td><td><input type="text" name="sdept" placeholder="Enter Department" /></td>
                </tr>
            </table>
        </center>
        <br/><button style="color:black; background-color:blanchedalmond;"><b>Register</b></button>
    </form>
    <br><a href="../JspPages/libDashboard.jsp"><button style="color:black; background-color:blanchedalmond;"><b>Dashboard<b></button></a> 
</div>

</body>
</html>