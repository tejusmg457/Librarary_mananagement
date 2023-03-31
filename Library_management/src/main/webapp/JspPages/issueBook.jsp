<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./header.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add book</title>
    </head>
    <body style="text-align: center; background-color: bisque;">
        <div style="background-color:lightcyan; height:280px; width:370px; text-align: center; margin-top: 8%; margin-left: 550px; border-radius: 50px;">
            <br>
            <h2 style="color:fuchsia;"><b><u>Enter the details</u></b></h2>
            <br>
            <form action="../Controller/issuebook" method="post">
                <center>
                    <table>
                       
                        <tr>
                            <td>Enter Book ID: </td><td><input type="text" name="bookid" placeholder="Enter book ID"></td>
                        </tr>
                        <tr>
                            <td>Enter Student regno:</td><td><input type="text" name="stdregno" placeholder="Enter student Reg No."></td>
                        </tr>
                        <tr>
                            <td>Issue date</td><td><input type="date" name="issuedate" ></td>
                        </tr>
                    </table>
                </center>
                <br>
                <button>Issue</button>
            </form>
             <br><a href="../JspPages/libDashboard.jsp"><button >Dashboard</button></a> 
        </div>
    </body>
</html>