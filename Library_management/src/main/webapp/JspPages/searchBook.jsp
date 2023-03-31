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
        <div style="background-color:lightcyan; height:270px; width:370px; text-align: center; margin-top:7%; margin-left: 550px; border-radius: 50px;">
            <br>
            <h2 style="color:fuchsia;"><b>Search book</b></h2>
            <form action="../Controller/getBookDetails" method="get">
                <center>
                    <table>  
                        <tr><td>Book ID </td><td><input type="text" name="bookid" placeholder="Enter ID"></td></tr>
                        <tr><td>Book name </td><td><input type="text" name="bookname" placeholder="Enter Name"></td></tr>
                        <tr><td>Author </td><td><input type="text" name="bookauthor" placeholder="Enter Author"></td></tr>
                        <tr><td>All details</td><td><input type="text" name="alldetails" placeholder="Yes/No"></td></tr>
                    </table>                </center>
                <br>
                <button>search</button>
            </form>
        </div>
    </body>
</html>