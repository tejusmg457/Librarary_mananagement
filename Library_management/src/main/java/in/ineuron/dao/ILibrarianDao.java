package in.ineuron.dao;

import java.util.ArrayList;

import in.ineuron.dto.*;

public interface ILibrarianDao {
	
	public String libLogIn(Librarian logindata);
	
	public String forloginPassword(String libid);
	
	public String addStudent(Student regStudent);
	
	public String addBook(Book addNewBook);
	
	public String issueBook(bookIssueData bookdata);
	
	public String deleteBook(String bookid);
	
	public String updateBook(Book bookUpdateData);
	
	public ArrayList<Book> searchAllBook();
	
	public Book searchByID(String bId);
	
	public Book searchByName(String bname);
	
	public Book searchByAuthor(String bauthor);
	
	public Book getbookdata(String Bookid);
	
	public bookIssueData returnBook(String stdregNo);
	
	public String returnProcess(bookIssueData returnData);
	
	public ArrayList<Student> studentlist();
	
	public Student searchStudent(String stdregNo);
	
	public String deleteStudent(String stdregNo);
	
	public String updateStudent(Student stdupdateData);
	
}
