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
        <div style="background-color:lightcyan; height:265px; width:370px; text-align: center; margin-top: 7%; margin-left: 575px; border-radius: 50px;">
            <br>
            <h2 style="color:fuchsia;"><b><u>Add new books!</u></b></h2>
            <br>
            <form action="../Controller/addBook" method="post">
                <center>
                    <table>
                       
                        <tr>
                            <td>Book ID: </td><td><input type="text" name="bookid" placeholder="Enter book ID"></td>
                        </tr>
                        <tr>
                            <td>Book name : </td><td><input type="text" name="bookname" placeholder="Enter Name"></td>
                        </tr>
                        <tr>
                            <td>Department: </td><td><input type="text" name="bookdep" placeholder="Enter Department"></td>
                        </tr>
                        <tr>
                        	<td>Author: </td><td><input type="text" name="bookauthor" placeholder="Enter author"></td>
                            
                        </tr>
                    </table>
                </center>
                <br>
                <button><b>Add<b></button>
            </form>
         </div>
        <br> <a href="../JspPages/libDashboard.jsp"><button><b>Dashboard<b></button></a> 
    </body>
</html>



    