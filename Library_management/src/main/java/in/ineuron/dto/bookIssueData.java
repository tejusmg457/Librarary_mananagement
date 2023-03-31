package in.ineuron.dto;

import java.io.Serializable;

public class bookIssueData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stdRegNo;
	private int bookCount;
	private String book1_id;
	private String book1_issuedate;
	private String book2_id;
	private String book2_issuedate;
	private String book3_id;
	private String book3_issuedate;
	private int returnNum;
	private String issuedate;
	
	public String getStdRegNo() {
		return stdRegNo;
	}
	public void setStdRegNo(String stdRegNo) {
		this.stdRegNo = stdRegNo;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getBook1_id() {
		return book1_id;
	}
	public void setBook1_id(String book1_id) {
		this.book1_id = book1_id;
	}
	public String getBook1_issuedate() {
		return book1_issuedate;
	}
	public void setBook1_issuedate(String issuedate) {
		this.book1_issuedate = issuedate;
	}
	public String getBook2_id() {
		return book2_id;
	}
	public void setBook2_id(String book2_id) {
		this.book2_id = book2_id;
	}
	public String getBook2_issuedate() {
		return book2_issuedate;
	}
	public void setBook2_issuedate(String book2_issuedate) {
		this.book2_issuedate = book2_issuedate;
	}
	public String getBook3_id() {
		return book3_id;
	}
	public void setBook3_id(String book3_id) {
		this.book3_id = book3_id;
	}
	public String getBook3_issuedate() {
		return book3_issuedate;
	}
	public void setBook3_issuedate(String book3_issuedate) {
		this.book3_issuedate = book3_issuedate;
	}
	public int getReturnNum() {
		return returnNum;
	}
	public void setReturnNum(int returnNum) {
		this.returnNum = returnNum;
	}
	
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	@Override
	public String toString() {
		return "bookIssueData [stdRegNo=" + stdRegNo + ", bookCount=" + bookCount + ", book1_id=" + book1_id
				+ ", book1_issuedate=" + book1_issuedate + ", book2_id=" + book2_id + ", book2_issuedate="
				+ book2_issuedate + ", book3_id=" + book3_id + ", book3_issuedate=" + book3_issuedate + ", returnNum="
				+ returnNum + ", issuedate=" + issuedate + "]";
	}
	
	
}
