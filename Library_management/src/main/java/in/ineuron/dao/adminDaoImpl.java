package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ineuron.dto.*;
import in.ineuron.util.JdbcUtil;

public class adminDaoImpl implements IAdminDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	@Override
	public String addLib(Librarian eldata) {
		String sqlInsertQuery = "insert into librarian(firstname, lastname, Employeeid, Password) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				
				pstmt.setString(1, eldata.getLibFirstName());
				pstmt.setString(2, eldata.getLibLastName());
				pstmt.setString(3, eldata.getLibID());
				pstmt.setString(4, eldata.getLpassword());

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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}	
		return "failure";	
	}

	@Override
	public Librarian searchLib(String lid) {
		String sqlSearchQuery = "Select firstname, lastname, Employeeid, Password from librarian where Employeeid=?";
		Librarian eldata = new Librarian();
		try {
				connection = JdbcUtil.getJdbcConnection();
	
				if (connection != null)
					pstmt = connection.prepareStatement(sqlSearchQuery);
	
				if (pstmt != null) {
					pstmt.setString(1, lid);
					System.out.println(pstmt);
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
	
						if (resultSet.next()) {
							eldata.setLibFirstName(resultSet.getString(1));
							eldata.setLibLastName(resultSet.getString(2));
							eldata.setLibID(resultSet.getString(3));
							eldata.setLpassword(resultSet.getString(4));
							
							try {
								JdbcUtil.cleanUp(connection, pstmt, resultSet);
								} catch (Exception e) {
								e.printStackTrace();
							}
							return eldata;
						}		
				}
			}
		}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		return eldata;
	}
	
	@Override
	public ArrayList<Librarian> allLibrarianDetails() {
		String sqlQuery = "select * from librarian";
	
		ArrayList<Librarian> al = new ArrayList<Librarian>();
		try {
				connection = JdbcUtil.getJdbcConnection();
	
				if (connection != null)
					pstmt = connection.prepareStatement(sqlQuery);
	
				if (pstmt != null) {
					System.out.println(pstmt);
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
						while(resultSet.next()) {
							Librarian eldata = new Librarian();

							eldata.setLibFirstName(resultSet.getString(1));
							eldata.setLibLastName(resultSet.getString(2));
							eldata.setLibID(resultSet.getString(3));
							eldata.setLpassword(resultSet.getString(4));

							al.add(eldata);
						}		
					}
				}
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		try {
			JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
		
	

	@Override
	public String UpdateLib(Librarian eldata) {
		
		String sqlUpdateQuery = "update librarian Set firstname=?, lastname=?, Password=? where Employeeid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, eldata.getLibFirstName());
				pstmt.setString(2, eldata.getLibLastName());
				pstmt.setString(3, eldata.getLpassword());
				pstmt.setString(4, eldata.getLibID());

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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public String deleteLib(String lid) {
		
		String sqlInsertQuery = "delete from librarian where Employeeid=?;";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				pstmt.setString(1, lid);
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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}	
		return "failure";
	}
}
