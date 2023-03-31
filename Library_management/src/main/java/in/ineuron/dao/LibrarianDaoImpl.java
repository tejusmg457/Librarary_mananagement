package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.ineuron.dto.*;
import in.ineuron.util.JdbcUtil;

public class LibrarianDaoImpl implements ILibrarianDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String libLogIn(Librarian logindata) {
		String sqlQuery = "Select Employeeid, password from librarian where Employeeid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			String libLogId = logindata.getLibID();
			String libLogPw = logindata.getLpassword();		
			
			if(pstmt!=null) {
				pstmt.setString(1, libLogId);
				resultSet = pstmt.executeQuery();
			}
			if(resultSet!=null) {
				while(resultSet.next()) {
					String libIdDb = resultSet.getString(1);
					String libPwDb = resultSet.getString(2);
					
					if((libIdDb.equalsIgnoreCase(libLogId)) && (libPwDb.equalsIgnoreCase(libLogPw))){
						try {
							JdbcUtil.cleanUp(connection, pstmt, resultSet);
							} catch (Exception e) {
							e.printStackTrace();
						}
						return "success";
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
	
	@Override
	public String forloginPassword(String libid) {
		String sqlQuery = "Select password from librarian where Employeeid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			if(pstmt!=null) {
				pstmt.setString(1, libid);
				resultSet = pstmt.executeQuery();
			}
			if(resultSet!=null) {
				while(resultSet.next()) {
					String libPwDb = resultSet.getString(1);
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return libPwDb;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String addStudent(Student regStudent) {
		String sqlInsertQuery = "insert into student(firstname, lastname, Regno, semester, Department) values (?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
				
			if (pstmt != null) {
				pstmt.setString(1, regStudent.getSFirstName());
				pstmt.setString(2, regStudent.getSLatstName());
				pstmt.setString(3, regStudent.getSRegNo());
				pstmt.setInt(4, regStudent.getSSem());
				pstmt.setString(5, regStudent.getSDep());
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					PreparedStatement pstmt = null;
					String sqlQuery = "insert into issuebook(stdregno, bookcount) values (?,?)";
					Connection connection1 = JdbcUtil.getJdbcConnection();
					if (connection1 != null)
						pstmt = connection.prepareStatement(sqlQuery);
						
					if (pstmt != null) {
						pstmt.setString(1, regStudent.getSRegNo());
						pstmt.setInt(2, 0);
						int rowAffected1 = pstmt.executeUpdate();
						if(rowAffected1==1) {
							try {
								JdbcUtil.cleanUp(connection, pstmt, resultSet);
								} catch (Exception e) {
								e.printStackTrace();
							}
							return "success";
						}
					}					
				}			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}			
		return "failure";
	}

	@Override
	public String addBook(Book addNewBook) {
		String sqlInsertQuery = "insert into book(book_id, book_name, book_department, book_author) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				
				pstmt.setString(1, addNewBook.getBookId());
				pstmt.setString(2, addNewBook.getBookName());
				pstmt.setString(3, addNewBook.getBookDepartment());
				pstmt.setString(4, addNewBook.getBookAuthor());
				
				
					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1) {
						try {
							JdbcUtil.cleanUp(connection, pstmt, resultSet);
							} catch (Exception e) {
							e.printStackTrace();
						}
						return "success";
					}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String issueBook(bookIssueData bookdata) {
		String sqlInsertQuery = "Select bookcount,book1_id, book2_id, book3_id from issuebook where stdregno=?";
		
		String book1_id=null, book2_id=null, book3_id=null;    //Once book returned those feilds replaced with null in order not to override the existing using this sit the respective column
		boolean book1 = false,book2 = false ,book3=false;
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String stdregno = bookdata.getStdRegNo();
		String bookid = bookdata.getBook1_id();
		String doissue = bookdata.getBook1_issuedate();
		int count=0;
		java.sql.Date sqldoissue = null;
		
		try {
		{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date uDate = sdf.parse(doissue);
				long value = uDate.getTime();
				
				
				sqldoissue = new java.sql.Date(value);
				
				connection = JdbcUtil.getJdbcConnection();
				
				pstmt = connection.prepareStatement(sqlInsertQuery);
				pstmt.setString(1, stdregno);
				resultSet = pstmt.executeQuery();
				if (resultSet!=null) {
					if(resultSet.next()) {
						count = resultSet.getInt(1);
						book1_id = resultSet.getString(2);
						book2_id = resultSet.getString(3);
						book3_id = resultSet.getString(4);
						
						book1 = book1_id==null;
						book2 = book2_id==null;
						book3 = book3_id==null;
						
					}
				}
			
				//Checking Book-ID
				String sqlquery = "select book_name from book where book_id=?";
				pstmt1 = connection.prepareStatement(sqlquery);
				pstmt1.setString(1, bookid);

				resultSet = pstmt1.executeQuery();
				if(resultSet.next() == false) {	
							return "bookIdInvalid";
						}		
			
				if(count==3) {
					return "over";		
				}else if(count==0){
					
					String sqlQuery = "update issuebook set book1_id=?, book1_issuedate=? where stdregno=?";
					pstmt2 = connection.prepareStatement(sqlQuery);
					
					pstmt2.setString(1, bookid);
					pstmt2.setDate(2, sqldoissue);
					pstmt2.setString(3, stdregno);
					
					int rowaffected = pstmt2.executeUpdate();
					if(rowaffected==1) {
						count++;
						String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
						pstmt3 = connection.prepareStatement(sqlQuery1);
						pstmt3.setInt(1, count);
						pstmt3.setString(2, stdregno);
						
						int rowaffected1 = pstmt3.executeUpdate();
						if(rowaffected1==1) {
							return "success";
						}	
					}	
				}else if(count==1){
					if(book1==true) {
						String sqlQuery = "update issuebook set book1_id=?, book1_issuedate=? where stdregno=?";
						pstmt2 = connection.prepareStatement(sqlQuery);
						
						pstmt2.setString(1, bookid);
						pstmt2.setDate(2, sqldoissue);
						pstmt2.setString(3, stdregno);
						
						int rowaffected = pstmt2.executeUpdate();
						if(rowaffected==1) {
							count++;
							String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
							pstmt3 = connection.prepareStatement(sqlQuery1);
							pstmt3.setInt(1, count);
							pstmt3.setString(2, stdregno);
							
							int rowaffected1 = pstmt3.executeUpdate();
							if(rowaffected1==1) {
								return "success";
							}	
						}	
					}else if(book2==true) {
						String sqlQuery = "update issuebook set book2_id=?, book2_issuedate=? where stdregno=?";
						pstmt2 = connection.prepareStatement(sqlQuery);
						
						pstmt2.setString(1, bookid);
						pstmt2.setDate(2, sqldoissue);
						pstmt2.setString(3, stdregno);
						
						int rowaffected = pstmt2.executeUpdate();
						if(rowaffected==1) {
							count++;
							String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
							pstmt3 = connection.prepareStatement(sqlQuery1);
							pstmt3.setInt(1, count);
							pstmt3.setString(2, stdregno);
							
							int rowaffected1 = pstmt3.executeUpdate();
							if(rowaffected1==1) {
								return "success";
							}	
						}	
						
					}else if(book3==true){
						String sqlQuery = "update issuebook set book3_id=?, book3_issuedate=? where stdregno=?";
						pstmt2 = connection.prepareStatement(sqlQuery);
						
						pstmt2.setString(1, bookid);
						pstmt2.setDate(2, sqldoissue);
						pstmt2.setString(3, stdregno);
						
						int rowaffected = pstmt2.executeUpdate();
						if(rowaffected==1) {
							count++;
							String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
							pstmt3 = connection.prepareStatement(sqlQuery1);
							pstmt3.setInt(1, count);
							pstmt3.setString(2, stdregno);
							
							int rowaffected1 = pstmt3.executeUpdate();
							if(rowaffected1==1) {
								return "success";
							}	
						}	
					}
								
				}else if(count==2){
					if(book1==true) {
						String sqlQuery = "update issuebook set book1_id=?, book1_issuedate=? where stdregno=?";
						pstmt2 = connection.prepareStatement(sqlQuery);
						
						pstmt2.setString(1, bookid);
						pstmt2.setDate(2, sqldoissue);
						pstmt2.setString(3, stdregno);
						
						int rowaffected = pstmt2.executeUpdate();
						if(rowaffected==1) {
							count++;
							String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
							pstmt3 = connection.prepareStatement(sqlQuery1);
							pstmt3.setInt(1, count);
							pstmt3.setString(2, stdregno);
							
							int rowaffected1 = pstmt3.executeUpdate();
							if(rowaffected1==1) {
								return "success";
						}	
					}
					}else if(book2==true) {
						String sqlQuery = "update issuebook set book2_id=?, book2_issuedate=? where stdregno=?";
						pstmt2 = connection.prepareStatement(sqlQuery);
						
						pstmt2.setString(1, bookid);
						pstmt2.setDate(2, sqldoissue);
						pstmt2.setString(3, stdregno);
						
						int rowaffected = pstmt2.executeUpdate();
						if(rowaffected==1) {
							count++;
							String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
							pstmt3 = connection.prepareStatement(sqlQuery1);
							pstmt3.setInt(1, count);
							pstmt3.setString(2, stdregno);
							
							int rowaffected1 = pstmt3.executeUpdate();
							if(rowaffected1==1) {
								return "success";
						}	
					}
				}
			else if(book3==true){
				String sqlQuery = "update issuebook set book3_id=?, book3_issuedate=? where stdregno=?";
				pstmt2 = connection.prepareStatement(sqlQuery);
				
				pstmt2.setString(1, bookid);
				pstmt2.setDate(2, sqldoissue);
				pstmt2.setString(3, stdregno);
				
				int rowaffected = pstmt2.executeUpdate();
				if(rowaffected==1) {
					count++;
					String sqlQuery1 = "Update issuebook set bookcount=? where stdregno=?";
					pstmt3 = connection.prepareStatement(sqlQuery1);
					pstmt3.setInt(1, count);
					pstmt3.setString(2, stdregno);
					
					int rowaffected1 = pstmt3.executeUpdate();
					if(rowaffected1==1) {
						try {
							JdbcUtil.cleanUp(connection, pstmt, resultSet);
							} catch (Exception e) {
							e.printStackTrace();
						}
						return "success";
					}	
				}	
			}					
		}
	}
		}catch(SQLException e) {
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return "failure";
}

	@Override
	public String deleteBook(String bookid) {
		String sqlRequestQuery = "delete from book where book_id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlRequestQuery);

			if (pstmt != null) {
				pstmt.setString(1, bookid);
				int roweffected = pstmt.executeUpdate();
				if(roweffected==1) {
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	return "failure";
	}
	
	@Override
	public Book getbookdata(String Bookid) {
		String sqlQuery = "Select book_id, book_name, book_department, book_author from book where book_id=?";
		Book bookRetriveData = new Book();
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);
				pstmt.setString(1, Bookid);
			
			
			if (pstmt != null) {
				System.out.println(pstmt);
				resultSet = pstmt.executeQuery();
			}if(resultSet!=null){
				while(resultSet.next()) {
					
					bookRetriveData.setBookId(resultSet.getString(1));
					bookRetriveData.setBookName(resultSet.getString(2));
					bookRetriveData.setBookDepartment(resultSet.getString(3));
					bookRetriveData.setBookAuthor(resultSet.getString(4));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return bookRetriveData;
	}

	@Override
	public String updateBook(Book bookUpdateData) {
		String sqlUpdateQuery = "update book set book_name=?, book_department=?, book_author=? where book_id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {
				
				pstmt.setString(1, bookUpdateData.getBookName());
				pstmt.setString(2, bookUpdateData.getBookDepartment());
				pstmt.setString(3, bookUpdateData.getBookAuthor());
				pstmt.setString(4, bookUpdateData.getBookId());
				System.out.println(pstmt);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return "success";
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
	

	@Override
	public ArrayList<Book> searchAllBook() {
		ArrayList<Book> bookfinal = new ArrayList<Book>();
		String sqlQuery = "Select book_id, book_name, book_department, book_author from book";
				try {
					connection = JdbcUtil.getJdbcConnection();
					if (connection != null)
						pstmt = connection.prepareStatement(sqlQuery);
	
					if (pstmt != null) {
						resultSet = pstmt.executeQuery();
					}if(resultSet!=null){
						while(resultSet.next()) {
							Book bookRetriveData = new 	Book();
							bookRetriveData.setBookId(resultSet.getString(1));
							bookRetriveData.setBookName(resultSet.getString(2));
							bookRetriveData.setBookDepartment(resultSet.getString(3));
							bookRetriveData.setBookAuthor(resultSet.getString(4));
						
							bookfinal.add(bookRetriveData);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return bookfinal;
	}
	
	@Override
	public bookIssueData returnBook(String stdregNo) {
		String sqlQuery = "select * from issuebook where stdregno=?";
		bookIssueData bookIssue = new bookIssueData();
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				pstmt.setString(1, stdregNo);
				
				resultSet = pstmt.executeQuery();
				if(resultSet!=null) {
					while(resultSet.next()) {
						String regNo = resultSet.getString(1);
						int count = resultSet.getInt(2);
						bookIssue.setStdRegNo(regNo);
						bookIssue.setBookCount(count);
						java.sql.Date book1SqlDate = resultSet.getDate(4);
						java.sql.Date book2SqlDate = resultSet.getDate(6);
						java.sql.Date book3SqlDate = resultSet.getDate(8);
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						if(count==1) {
							
							String book1Date = sdf.format(book1SqlDate);

							bookIssue.setBook1_id(resultSet.getString(3));
							bookIssue.setBook1_issuedate(book1Date);
							return bookIssue;
							
						}else if(count==2) {
							
							String book1Date = sdf.format(book1SqlDate);
							String book2Date = sdf.format(book2SqlDate);
							
							bookIssue.setBook1_id(resultSet.getString(3));
							bookIssue.setBook1_issuedate(book1Date);
							bookIssue.setBook2_id(resultSet.getString(5));
							bookIssue.setBook2_issuedate(book2Date);
							
							return bookIssue;
							
						}else if(count==3) {
							
							String book1Date = sdf.format(book1SqlDate);
							String book2Date = sdf.format(book2SqlDate);
							String book3Date = sdf.format(book3SqlDate);
														
							bookIssue.setBook1_id(resultSet.getString(3));
							bookIssue.setBook1_issuedate(book1Date);
							bookIssue.setBook2_id(resultSet.getString(5));
							bookIssue.setBook2_issuedate(book2Date);
							bookIssue.setBook3_id(resultSet.getString(7));
							bookIssue.setBook3_issuedate(book3Date);
							System.out.println(bookIssue);
							return bookIssue;
						}			
					}
				}
				
				
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookIssue;
	}
	
	@Override
	public ArrayList<Student> studentlist() {
		String sqlQuery = "Select * from student";
		
		ArrayList<Student> al = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}if(resultSet!=null){
				while(resultSet.next()) {
					Student studentRetriveData = new Student();
					studentRetriveData.setSFirstName(resultSet.getString(1));
					studentRetriveData.setSLatstName(resultSet.getString(2));
					studentRetriveData.setSRegNo(resultSet.getString(3));
					studentRetriveData.setSSem(resultSet.getInt(4));
					studentRetriveData.setSDep(resultSet.getString(5));
					
					al.add(studentRetriveData);	
				}
		}} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Student searchStudent(String stdregNo) {
		String sqlQuery = "Select firstname, lastname, Regno, semester, Department from Student where Regno=?";
		Student Stddata = new Student();
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				pstmt.setString(1, stdregNo);
				resultSet = pstmt.executeQuery();
				if(resultSet!=null) {
					while(resultSet.next()) {
						Stddata.setSFirstName(resultSet.getString(1));
						Stddata.setSLatstName(resultSet.getString(2));
						Stddata.setSRegNo(resultSet.getString(3));
						Stddata.setSSem(resultSet.getInt(4));
						Stddata.setSDep(resultSet.getString(5));
						return Stddata;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return Stddata;
	}

	@Override
	public String deleteStudent(String stdregNo) {
		String sqlQuery = "delete from `student` where Regno = ?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				pstmt.setString(1, stdregNo);
				int rowAffected = pstmt.executeUpdate();
					if(rowAffected==1) {
						try {
							JdbcUtil.cleanUp(connection, pstmt, resultSet);
							} catch (Exception e) {
							e.printStackTrace();
						}
						return "success";
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String updateStudent(Student stdupdateData) {
	String sqlQuery = "update student set firstname=?, lastname=?, semester=?, Department=? where Regno=?";
	try {
		connection = JdbcUtil.getJdbcConnection();
		if (connection != null)
			pstmt = connection.prepareStatement(sqlQuery);

		if (pstmt != null) {
			pstmt.setString(1, stdupdateData.getSFirstName());
			pstmt.setString(2, stdupdateData.getSLatstName());
			pstmt.setInt(3, stdupdateData.getSSem());
			pstmt.setString(4, stdupdateData.getSDep());
			pstmt.setString(5, stdupdateData.getSRegNo());
			
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected==1) {
				try {
					JdbcUtil.cleanUp(connection, pstmt, resultSet);
					} catch (Exception e) {
					e.printStackTrace();
				}
				return "success";
				}
			}
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return "failure";	
	}

	@Override
	public String returnProcess(bookIssueData returnData) {
		int bookcount = 0;
		String regNo = returnData.getStdRegNo();
		int returnNo = returnData.getReturnNum();
		PreparedStatement pstmt1 = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				if(returnNo==1) {
					pstmt = connection.prepareStatement("Select bookcount from issuebook where stdregno=?");
					pstmt.setString(1, regNo);
					resultSet = pstmt.executeQuery();
						while(resultSet.next()) {
							
							System.out.println(bookcount);
							bookcount--;

						}
						
						String sqlQuery = "UPDATE `issuebook` SET `book1_id` = NULL, `book1_issuedate` = NULL, bookcount=? WHERE `stdregno` = ?;";	
						pstmt1 = connection.prepareStatement(sqlQuery);
						pstmt1.setInt(1, bookcount);
						pstmt1.setString(2, regNo);
						int rowAffected = pstmt1.executeUpdate();
							if(rowAffected==1) {
								return "success";
						}	
				}else if(returnNo==2) {
					pstmt = connection.prepareStatement("Select bookcount from issuebook where stdregno=?");
					pstmt.setString(1, regNo);
					resultSet = pstmt.executeQuery();
						while(resultSet.next()) {
							
							bookcount = resultSet.getInt(1);
							System.out.println(bookcount);
							bookcount--;

						}
						
						String sqlQuery = "UPDATE `issuebook` SET `book2_id` = NULL, `book2_issuedate` = NULL, bookcount=? WHERE `stdregno` = ?;";	
						pstmt1 = connection.prepareStatement(sqlQuery);
						pstmt1.setInt(1, bookcount);
						pstmt1.setString(2, regNo);
						int rowAffected = pstmt1.executeUpdate();
							if(rowAffected==1) {
								return "success";
						}	
				}if(returnNo==3) {
					pstmt = connection.prepareStatement("Select bookcount from issuebook where stdregno=?");
					pstmt.setString(1, regNo);
					resultSet = pstmt.executeQuery();
						while(resultSet.next()) {
							
							bookcount = resultSet.getInt(1);
							bookcount--;
						}
						
						String sqlQuery = "UPDATE `issuebook` SET `book3_id` = NULL, `book3_issuedate` = NULL, bookcount=? WHERE `stdregno` = ?;";	
						pstmt1 = connection.prepareStatement(sqlQuery);
						pstmt1.setInt(1, bookcount);
						pstmt1.setString(2, regNo);
						int rowAffected = pstmt1.executeUpdate();
							if(rowAffected==1) {
								return "success";
						}	
				}
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
			} catch (Exception e) {
			e.printStackTrace();
			}
			return "failure";	
	}

	@Override
	public Book searchByID(String bId) {
		String sqlQuery = "Select book_id, book_name, book_department, book_author from book where book_id=?";
		Book bookRetriveData = new 	Book();
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				pstmt.setString(1, bId);
				resultSet = pstmt.executeQuery();	
			}if(resultSet!=null){
				while(resultSet.next()) {
					bookRetriveData.setBookId(resultSet.getString(1));
					bookRetriveData.setBookName(resultSet.getString(2));
					bookRetriveData.setBookDepartment(resultSet.getString(3));
					bookRetriveData.setBookAuthor(resultSet.getString(4));
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return bookRetriveData;
				}
			
			}}catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return bookRetriveData;
	}

	@Override
	public Book searchByName(String bname) {
		String sqlQuery = "Select book_id, book_name, book_department, book_author from book where book_name=?";
		Book bookRetriveDataN = new Book();
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
				pstmt.setString(1, bname);
				resultSet = pstmt.executeQuery();	
			}if(resultSet!=null){
				while(resultSet.next()) {
					bookRetriveDataN.setBookId(resultSet.getString(1));
					bookRetriveDataN.setBookName(resultSet.getString(2));
					bookRetriveDataN.setBookDepartment(resultSet.getString(3));
					bookRetriveDataN.setBookAuthor(resultSet.getString(4));
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return bookRetriveDataN;
				}
			
			}}catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return bookRetriveDataN;
	}

	@Override
	public Book searchByAuthor(String bauthor) {
		String sqlQuery = "Select book_id, book_name, book_department, book_author from book where book_author=?";
		Book bookRetriveDataA = new Book();
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlQuery);

			if (pstmt != null) {
			 	pstmt.setString(1, bauthor);
				resultSet = pstmt.executeQuery();	
			}if(resultSet!=null){
				while(resultSet.next()) {
					
					bookRetriveDataA.setBookId(resultSet.getString(1));
					bookRetriveDataA.setBookName(resultSet.getString(2));
					bookRetriveDataA.setBookDepartment(resultSet.getString(3));
					bookRetriveDataA.setBookAuthor(resultSet.getString(4));
					try {
						JdbcUtil.cleanUp(connection, pstmt, resultSet);
						} catch (Exception e) {
						e.printStackTrace();
					}
					return bookRetriveDataA;
				}			
			}}catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return bookRetriveDataA;
	}
}

