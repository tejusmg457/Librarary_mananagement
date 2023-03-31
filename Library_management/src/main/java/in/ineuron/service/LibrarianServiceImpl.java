package in.ineuron.service;

import in.ineuron.dto.*;

import java.util.ArrayList;

import in.ineuron.dao.ILibrarianDao;
import in.ineuron.daofactory.librarianDaoFactory;

public class LibrarianServiceImpl implements ILibrarianService {
	
	private ILibrarianDao librarianDao;
	
	@Override
	public String libLogIn(Librarian logindata) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.libLogIn(logindata);
		
	}
	
	@Override
	public String forloginPassword(String libid) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.forloginPassword(libid);
	}

	@Override
	public String addStudent(Student regStudent) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.addStudent(regStudent);
	}

	@Override
	public String addBook(Book addNewBook) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.addBook(addNewBook);
	}

	@Override
	public String issueBook(bookIssueData bookdata) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.issueBook(bookdata);
	}

	@Override
	public String deleteBook(String bookid) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.deleteBook(bookid);
	}
	
	@Override
	public Book getbookdata(String Bookid) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.getbookdata(Bookid);
	}

	@Override
	public String updateBook(Book bookUpdateData) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.updateBook(bookUpdateData);
	}

	@Override
	public ArrayList<Book> searchAllBook() {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.searchAllBook();
	}

	@Override
	public bookIssueData returnBook(String stdregNo) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.returnBook(stdregNo);
		
	}

	@Override
	public ArrayList<Student> studentlist() {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.studentlist();
		
	}

	@Override
	public Student searchStudent(String stdregNo) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.searchStudent(stdregNo);
	}

	@Override
	public String deleteStudent(String stdregNo) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.deleteStudent(stdregNo);
	}

	@Override
	public String updateStudent(Student stdupdateData) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.updateStudent(stdupdateData);
	}

	@Override
	public String returnProcess(bookIssueData returnData) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.returnProcess(returnData);
	}

	@Override
	public Book searchByID(String bId) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.searchByID(bId);
	}

	@Override
	public Book searchByName(String bname) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.searchByName(bname);
	}

	@Override
	public Book searchByAuthor(String bauthor) {
		librarianDao = librarianDaoFactory.getStudentDao();
		return librarianDao.searchByAuthor(bauthor);
	}

	
}
