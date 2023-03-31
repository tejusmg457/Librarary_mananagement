<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="./header.jsp" %>
     <%@ page import="in.ineuron.dto.bookIssueData" %>
     <%  bookIssueData issuedata = (bookIssueData) session.getAttribute("issueddata"); %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book return Process</title>
</head>
<body style="text-align: center;">
<br/>
 <% HttpSession sess = request.getSession(); %>
<% int count= issuedata.getBookCount(); 
     if(count==0) { %>
              <h2 style="color: red">Register No: <%= issuedata.getStdRegNo() %> Student didn't received any book<h2> 
              <% } %>
	
	<center>
        <table>
        	
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book Count</b></th>
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book1_ID</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book1_Issuedate</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Return</b></th>            
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book2_ID</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book2_Issuedate</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Return</b></th>            
            <th style="height: 30px; width: 200px; background-color: lightcyan; color: blue;"><b>Book3_ID</b></th>
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Book3_Issuedate</b></th>            
            <th style="width: 200px; background-color: lightcyan; border: 10px; color: blue;"><b>Return</b></th>            
           
           <% if (count==1) { %> 
          	<h3 style="color:blue;">Register No: <%= issuedata.getStdRegNo() %> student book transactions details are as fallows::</h3>
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
            	<td><b><%= count %><b></td>
                <td><%= issuedata.getBook1_id() %></td>
                <td><%= issuedata.getBook1_issuedate() %></td> 
                
                <form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(1);
                    issuedata.setIssuedate(issuedata.getBook1_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>
              
                <td><button>Return</button></td>
                </form>
                 
                <td></td><td></td><td></td> 
                </td><td></td><td></td><td></td>      
                
            </tr>
             <% } %> 
             
             <% if (count==2) { %> 
          	<h3 style="color:blue;">Register No: <%= issuedata.getStdRegNo() %> student book transactions details are as fallows::</h3>
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
            	<td><b><%= count %><b></td>
                <td><%= issuedata.getBook1_id() %></td>
                <td><%= issuedata.getBook1_issuedate() %></td>
                
                <form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(1);
                    issuedata.setIssuedate(issuedata.getBook1_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>            
                	<td><button>Return</button></td>
                </form>   
                
                <td><%= issuedata.getBook2_id() %></td>
                <td><%= issuedata.getBook2_issuedate() %></td>
                
				<form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(2);
                    issuedata.setIssuedate(issuedata.getBook2_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>
					<td><button>Return</button></td>
					
                </form> 

                </td><td></td><td></td><td></td>      
            </tr>
             <% } %> 
             
            <% if (count==3) { %> 
          	<h3 style="color:blue;">Register No: <%= issuedata.getStdRegNo() %> student book transactions details are as fallows::</h3>
            <tr style="height: 30px; width: 200px; background-color: lightcyan; text-align: center;">
            	<td><b><%= count %><b></td>
                <td><%= issuedata.getBook1_id() %></td>
                <td><%= issuedata.getBook1_issuedate() %></td> 
                 
				<form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(1);
                    issuedata.setIssuedate(issuedata.getBook1_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>
              
                <td><button>Return</button></td>
                </form> 

                <td><%= issuedata.getBook2_id() %></td>
                <td><%= issuedata.getBook2_issuedate() %></td>
                
                <form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(2);
                    issuedata.setIssuedate(issuedata.getBook1_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>
              
                <td><button>Return</button></td>
                </form> 

                <td><%= issuedata.getBook3_id() %></td>
                <td><%= issuedata.getBook3_issuedate() %></td>

				<form action="../Controller/returnBookProcess" method="post">
                <% 
                    issuedata.setStdRegNo(issuedata.getStdRegNo());
                    issuedata.setReturnNum(3);
                    issuedata.setIssuedate(issuedata.getBook3_issuedate()); 
                    
	                sess.setAttribute("book", issuedata);  %>
              
                <td><button>Return</button></td>
                </form> 

            </tr>
             <% } %> 
        </table>
        <br><a href="../JspPages/libDashboard.jsp"><button >Dashboard</button></a> 
    </center>

</body>
</html>