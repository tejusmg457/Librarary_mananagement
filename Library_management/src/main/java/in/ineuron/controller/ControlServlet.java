package in.ineuron.controller;

import in.ineuron.servicefactory.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import in.ineuron.dao.*;
import in.ineuron.dto.*;
import in.ineuron.service.IAdminService;
import in.ineuron.service.ILibrarianService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

@WebServlet("/Controller/*")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControlServlet() {
        super();
       
    }
    
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if (request.getRequestURI().endsWith("getBookDetails")) {											//get books data		
    		String bookid = request.getParameter("bookid");
    		String bookname = request.getParameter("bookname");
    		String bookauthor = request.getParameter("bookauthor");
    		String alldetails = request.getParameter("alldetails");
    		
    		int bid = bookid.length();
    		int bname = bookname.length();
    		int bauth = bookauthor.length();
    		int allbook = alldetails.length();
    		
    		Book bookSearch = new Book();
    		bookSearch.setAlldata(alldetails);
    		bookSearch.setBookId(bookid);
    		bookSearch.setBookName(bookname);
    		bookSearch.setBookAuthor(bookauthor);
    		if(bid>0) {
        		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    			Book bookdata = librarianService.searchByID(bookid);
    			
    			HttpSession session = request.getSession();
    			session.setAttribute("bookdataid", bookdata);
     		    response.sendRedirect("../JspPages/dispbook1.jsp");	
        		}
    		if(bname>0) {
        		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    			Book bookdata = librarianService.searchByName(bookname);
    			
    			HttpSession session = request.getSession();
    			session.setAttribute("bookdataname", bookdata);
     		    response.sendRedirect("../JspPages/dispbook1.jsp");	
        		}
    		if(bauth>0) {
        		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    			Book bookdata = librarianService.searchByAuthor(bookauthor);
    			
    			HttpSession session = request.getSession();
    			session.setAttribute("bookdataauthor", bookdata);
     		    response.sendRedirect("../JspPages/dispbook1.jsp");	
        		}
    		if(allbook==3) {
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			ArrayList<Book> al = librarianService.searchAllBook();
			
			HttpSession session = request.getSession();
			session.setAttribute("bookdata",al);
 		    response.sendRedirect("../JspPages/dispbook.jsp");	
    		}
    	}
	}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
   
    	if (request.getRequestURI().endsWith("adminLogin")) {												//admin login
    	String adminId = request.getParameter("adminid");
    	String adminPw = request.getParameter("adminpw");
    	
    	if((adminId.equalsIgnoreCase("admin1")) && (adminPw.equalsIgnoreCase("admin123"))){    		
	    	RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/adminDashboard.jsp");
			reqDis.include(request, response);
    	}else {
    		RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/adminLogin.jsp");
    		reqDis.include(request, response);
    		out.println("<br/><br/><h2 style='text-align:center; color:red;'>Login failed!</h2>");	
    	}
	}
    	
    	if (request.getRequestURI().endsWith("addLibrarian")) {											//addlibrarian
    		 String lfname = request.getParameter("lfname");
			 String llname = request.getParameter("llname");
			 String lid = request.getParameter("lid");
			 String lpassword = request.getParameter("lpassword");
			 
			 Librarian eldata = new Librarian();
			 eldata.setLibFirstName(lfname);
			 eldata.setLibLastName(llname);
			 eldata.setLibID(lid);
			 eldata.setLpassword(lpassword);
			 
			 IAdminService adminService = adminServiceFactory.getadminService();
		     String msg = adminService.addLib(eldata);
			 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/Addlibrarian.jsp");	 
			 if (msg.equalsIgnoreCase("success")) {	
					reqDis.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:green;'>Librarian Registration successfull</h1>");
				}else {
					reqDis.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:green;'>Librarian Registration failed</h1>");
				}
    	}
    	
    	if (request.getRequestURI().endsWith("searchLibrarian")) {															//search librarian
    		
    		String lid = request.getParameter("lid");
    		IAdminService adminService = adminServiceFactory.getadminService();
		    Librarian Libdata = adminService.searchLib(lid);    
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("Libdata", Libdata);
		    response.sendRedirect("../JspPages/dispLibrarian.jsp");
			 				
    	}
    	
    	if (request.getRequestURI().endsWith("allLibrarianData")) {														//get librarian details
    		IAdminService adminService = adminServiceFactory.getadminService();
    		ArrayList<Librarian> Liballdata = adminService.allLibrarianDetails();  
    		System.out.println("camedata");
    		HttpSession session = request.getSession();
 		    session.setAttribute("Libdata", Liballdata);
 		    response.sendRedirect("../JspPages/dispAllLibrarian.jsp");
    	}
    	
    	if (request.getRequestURI().endsWith("deleteLibrarian")) {															//delete librarian
    		
    		String lid = request.getParameter("lid");
    		
    		IAdminService adminService = adminServiceFactory.getadminService();
		     String msg = adminService.deleteLib(lid);
			 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/deleteLibrarian.jsp");	 
			 if (msg.equalsIgnoreCase("success")) {	
					reqDis.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:green;'>Deletion successfull</h1>");
				}else {
					 RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/deleteLibrarian.jsp");
					reqDis1.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:green;'>Deletion failed</h1>");
				}				
    	}
    	
    	if(request.getRequestURI().endsWith("editLibrarian")) {
    		String lid = request.getParameter("lid");
    		IAdminService adminService = adminServiceFactory.getadminService();
		    Librarian Libdata = adminService.searchLib(lid);    
		    
		    if(Libdata!=null) {
		    	HttpSession session = request.getSession();
			    session.setAttribute("Libdata", Libdata);
			    response.sendRedirect("../JspPages/updateLibrarian.jsp");		
		    }
		    
    	}
    	
    	if (request.getRequestURI().endsWith("updateLibrarian")) {																//update librarian
    		
    		String lid = request.getParameter("lid");
    		String lfname= request.getParameter("lfname");
    		String llname = request.getParameter("llname");
    		String lpw = request.getParameter("lpassword");
    		
    		Librarian eldata = new Librarian();
    		
    		eldata.setLibFirstName(lfname);
    		eldata.setLibLastName(llname);
    		eldata.setLibID(lid);
    		eldata.setLpassword(lpw);
    		
    		 IAdminService adminService = adminServiceFactory.getadminService();
		     String msg = adminService.UpdateLib(eldata);
			 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/getLibrarian.jsp");	 
			 if (msg.equalsIgnoreCase("success")) {	
					reqDis.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:green;'>Update successfull</h1>");
				}else {
					RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/getLibrarian.jsp");	 
					reqDis1.include(request, response);
					out.println("<br/><br/><h1 style='text-align:center; color:red;'>Update failed enter details correctly</h1>");
				}
    		
    		
    	}
    	
    	
    	if (request.getRequestURI().endsWith("librarianLogin")) {																		//librarian login
    		
    		String lid = request.getParameter("lid");
    		String lpw = request.getParameter("lpw");
    		
    		Librarian logindata = new Librarian();
    		logindata.setLibID(lid);
    		logindata.setLpassword(lpw);
    	
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
		     String msg = librarianService.libLogIn(logindata);
		     RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/libDashboard.jsp");
		     if(msg.equalsIgnoreCase("success")) {	
		    	 reqDis.forward(request, response);
		     }else {
		    	 RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/librarianLogin.jsp");
					reqDis1.include(request, response);
					out.println("<br/><br/><h2 style='text-align:center; color:red;'>Login failed! Invalid username or password</h2>");
				}
    	}
    	
    	if (request.getRequestURI().endsWith("forgotLibPassword")) {																	//forgot lib password
    		
    		String lid = request.getParameter("lid");
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
		    String msg = librarianService.forloginPassword(lid);
    		 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/librarianLogin.jsp");	
    		 if(msg.equalsIgnoreCase("failure")) {
    			 reqDis.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:green;'>Invalid ID</h2>");		
    		 }else {
    			 RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/librarianLogin.jsp");
    			 reqDis1.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:green;'>Your Password is :: " + msg + " </h2>");
    		 }
    		 
    		
    	}
    	
    	if (request.getRequestURI().endsWith("addStudent")) {																		//add student
    		
    		Student regStudent = new Student();
    		regStudent.setSFirstName(request.getParameter("sfname"));
    		regStudent.setSLatstName(request.getParameter("slname"));
    		regStudent.setSRegNo(request.getParameter("sreg"));
    		regStudent.setSSem(Integer.parseInt(request.getParameter("ssem")));
    		regStudent.setSDep(request.getParameter("sdept"));
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
		    String msg = librarianService.addStudent(regStudent);
    		 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/addStudent.jsp");	
    		 if(msg.equalsIgnoreCase("success")) {
    			 reqDis.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:green;'>Student added successfully!</h2>");		
    		 }else {
    			 RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/addStudent.jsp");	
    			 reqDis1.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:red;'>failed to insert Student details! Try again</h2>");
    		 }
    	
    	}
    	if (request.getRequestURI().endsWith("searchStudent")) {														//search student
    		String StdregNo = request.getParameter("stdregNo");
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			Student stddata = librarianService.searchStudent(StdregNo);
			if(stddata!=null) {
				HttpSession session = request.getSession();
	 		    session.setAttribute("studentData", stddata);
	 		    response.sendRedirect("../JspPages/dispSingleStudent.jsp");
			}else {
				RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/searchStudent.jsp");	
				reqDis.include(request, response);
    			out.println("<br/><br/><h2 style='text-align:center; color:red;'>failed to search Student details! check Student RegNo.</h2>");
			}
    	}
    	
    	if (request.getRequestURI().endsWith("deleteStudent")) {														//delete student
    		String StdregNo = request.getParameter("stdregno");
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			String msg= librarianService.deleteStudent(StdregNo);
			if(msg.equalsIgnoreCase("success")) {
				RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/deleteStudent.jsp");	
				reqDis.include(request, response);
    			out.println("<br/><br/><h2 style='text-align:center; color:green;'>Student data deleted successfully</h2>");
			}else {
				RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/deleteStudent.jsp");	
				reqDis.include(request, response);
    			out.println("<br/><br/><h2 style='text-align:center; color:red;'>failed to delete Student details! check Student RegNo.</h2>");
			}
    	}
    	
    	if (request.getRequestURI().endsWith("addBook")) {																					//add book
			
			Book addNewBook = new Book();
			
			addNewBook.setBookId(request.getParameter("bookid"));
			addNewBook.setBookName(request.getParameter("bookname"));
			addNewBook.setBookDepartment(request.getParameter("bookdep"));
			addNewBook.setBookAuthor(request.getParameter("bookauthor"));
			
			ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			String msg = librarianService.addBook(addNewBook);
			RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/addBook.jsp");
			if (msg.equalsIgnoreCase("success")) {	
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:green';>Book details inserted successfully!<h3>");
			} else {
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:red';>Book details insertion failed! try again<h3>");
			}
   		
   	}
    	
    	if (request.getRequestURI().endsWith("issuebook")) {																		//issue book
			
			String bookid = request.getParameter("bookid");
			String stdregno = request.getParameter("stdregno");
			String issuedate = request.getParameter("issuedate");
			System.out.println(issuedate);
			
			bookIssueData bookdata = new bookIssueData();
			bookdata.setBook1_id(bookid);
			bookdata.setStdRegNo(stdregno);
			bookdata.setBook1_issuedate(issuedate);
			
			ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			String msg = librarianService.issueBook(bookdata);
			RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/issueBook.jsp");
			if (msg.equalsIgnoreCase("success")) {				
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:blue';><b>Book issued successfully!<b><h3>");
			}if (msg.equalsIgnoreCase("failure")) {
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:red';><b>Invalid Student register number!<b><h3>");
			}if (msg.equalsIgnoreCase("over")) {
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:red';><b>limit over: student already received three book<b><h3>");
			}if (msg.equalsIgnoreCase("bookIdInvalid")) {
				reqDis.include(request, response);
				out.println("<h3 style='text-align:center; color:red';><b>Invalid Book ID! <b><h3>");
			}
		}
    	
    	if (request.getRequestURI().endsWith("deleteBook")) {																					//delete book			
			String bookid = request.getParameter("bookid");
			
			ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			String msg = librarianService.deleteBook(bookid);
				if (msg.equalsIgnoreCase("success")) {	
					RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/deleteBook.jsp");
					reqDis.include(request, response);
					out.println("<h2 style='text-align:center; color:green';>Book deleted successfully</h2>");
				} else {
					RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/deleteBook.jsp");
					reqDis.include(request, response);
					out.println("<h2 style='text-align:center; color:red';>Book deletion failed! check book ID</h2>");
				}
			} 
    	
    	if (request.getRequestURI().endsWith("editBook")) {	
    		String bookid = request.getParameter("bookid");
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			Book bookdata = librarianService.getbookdata(bookid);
			
			if(bookdata!=null) {
				HttpSession session = request.getSession();
	 		    session.setAttribute("bookdata", bookdata);
	 		    response.sendRedirect("../JspPages/updateBook.jsp");
			}else {
				RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/getBook.jsp");
				reqDis.include(request, response);
				out.println("<h2 style='text-align:center; color:red';>Book details retreive fail! check Book ID</h2>");
			}		
    	}
    	
    	if (request.getRequestURI().endsWith("updateBook")) {
    		
    		Book bookUpdateData = new Book();
    		bookUpdateData.setBookName(request.getParameter("bname"));
    		bookUpdateData.setBookId(request.getParameter("bid"));
    		bookUpdateData.setBookDepartment(request.getParameter("bdep"));
    		bookUpdateData.setBookAuthor(request.getParameter("bauthor"));
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    		String msg = librarianService.updateBook(bookUpdateData);
    		if(msg.equalsIgnoreCase("success")) {
    			RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/getBook.jsp");
				reqDis.include(request, response);
				out.println("<h2 style='text-align:center; color:green';>Book update successfull</h2>");
    		}else {
    			RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/updateBook.jsp");
				reqDis.include(request, response);
				out.println("<h2 style='text-align:center; color:red';>Book update failed</h2>");
    		}
    	}
    	
    	if (request.getRequestURI().endsWith("returnBook")) {											//return book
    		
    		String stdregNo = request.getParameter("stdregNo");
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    		bookIssueData issuedata = librarianService.returnBook(stdregNo);
    		
    		HttpSession session = request.getSession();
 		    session.setAttribute("issueddata", issuedata);
 		    response.sendRedirect("../JspPages/returnBookProcess.jsp");
    	}
    	
    	if (request.getRequestURI().endsWith("returnBookProcess")) {													//return process 
    		HttpSession sess = request.getSession();
    		bookIssueData returnData = (bookIssueData)sess.getAttribute("book");
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
    		String msg = librarianService.returnProcess(returnData);
    		if(msg.equalsIgnoreCase("success")) {
    			
    			String issuedate = returnData.getIssuedate();
    			Date d= new Date();
		
    			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date bookdate = sdf.parse(issuedate);
				
					String date = sdf.format(d);
					Date currentdate = sdf.parse(date);
    			
		    			long diff = currentdate.getTime() - bookdate.getTime();
		    			long dayDiff = ( diff/(1000*60*60*24) );	
		    			RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/returnBookProcess.jsp");	
		    			if(dayDiff<15) {
		    				reqDis.include(request, response);
		    				out.println("<h2 style='color: green;'>Update successfull<h2>");
		    				out.println(" <h2 style='color: teal;'>No of days book kept :: ' " + dayDiff +  " ' <h2> ");
		    				out.println(" <h2 style='color: teal;'>fine Amount :: 0 <h2> ");	
		    			}else {
		    				long fineAmount = (dayDiff-15)*10;
		    				reqDis.include(request, response);
		    				out.println("<h2 style='color: green;'>Update successfull<h2>");
		    				out.println(" <h2 style='color: teal;'>Book kept more than 15 days, total days kept ::  " + dayDiff +  "  <h2> ");
		    				out.println(" <h2 style='color: teal;'>fine Amount ::  " + fineAmount + " rs<h2> ");		
		    			}
				} catch (ParseException e) {
					e.printStackTrace();
				}		
    		}	
    	}
    	
    	
    	
    	if (request.getRequestURI().endsWith("studentList")) {																				//student list		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			ArrayList<Student> StudentRetrivalData = librarianService.studentlist();
			int row = StudentRetrivalData.size();
			for(int i=0; i<row; i++ ) {
				Student std = (Student) StudentRetrivalData.get(i);
				
				System.out.println(std);
			}
			
			HttpSession session = request.getSession();
 		    session.setAttribute("studentData", StudentRetrivalData);
 		    response.sendRedirect("../JspPages/dispStudent.jsp");
    	}	
    	
    	if (request.getRequestURI().endsWith("searchUpdateStudent")) {														//search student
    		String StdregNo = request.getParameter("stdregNo");
    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
			Student stddata = librarianService.searchStudent(StdregNo);
			if(stddata!=null) {
				HttpSession session = request.getSession();
	 		    session.setAttribute("studentData", stddata);
	 		    response.sendRedirect("../JspPages/updateStudent.jsp");
			}else {
				RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/getStudent.jsp");	
				reqDis.include(request, response);
    			out.println("<br/><br/><h2 style='text-align:center; color:red;'>failed to search Student details! check Student RegNo.</h2>");
			}
    	}
    	
    	if (request.getRequestURI().endsWith("updateStudent")) {	

    		Student stdupdateData = new Student();
    		stdupdateData.setSFirstName(request.getParameter("sfname"));
    		stdupdateData.setSLatstName(request.getParameter("slname"));
    		stdupdateData.setSRegNo(request.getParameter("sreg"));
    		stdupdateData.setSSem(Integer.parseInt(request.getParameter("ssem")));
    		stdupdateData.setSDep(request.getParameter("sdept"));

    		
    		ILibrarianService librarianService = librarianServiceFactory.getLibrarianService();
		    String msg = librarianService.updateStudent(stdupdateData);
    		 RequestDispatcher reqDis = request.getRequestDispatcher("../JspPages/getStudent.jsp");	
    		 if(msg.equalsIgnoreCase("success")) {
    			 reqDis.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:green;'>Student details updated successfully!</h2>");		
    		 }else {
    			 RequestDispatcher reqDis1 = request.getRequestDispatcher("../JspPages/getStudent.jsp");	
    			 reqDis1.include(request, response);
    			 out.println("<br/><br/><h2 style='text-align:center; color:red;'>Student details updation failed! Try again</h2>");
    		 }
    		
    	}
    }
}

