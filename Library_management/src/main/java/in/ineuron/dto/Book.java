package in.ineuron.dto;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String bookId;
	private String bookName;
	private String bookDepartment;
	private String bookAuthor;
	private String alldata;
	
	public String getAlldata() {
		return alldata;
	}
	public void setAlldata(String alldata) {
		this.alldata = alldata;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDepartment() {
		return bookDepartment;
	}
	public void setBookDepartment(String bookDepartment) {
		this.bookDepartment = bookDepartment;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookDepartment=" + bookDepartment
				+ ", bookAuthor=" + bookAuthor + ", alldata=" + alldata + "]";
	}
	
	
}
