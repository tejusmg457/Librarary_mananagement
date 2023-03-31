package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.Statement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	/*public static Connection getJdbcConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("E:\\Project_code\\Library_management\\src\\main\\java\\in\\ineuron\\properties\\dbinfo.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String User = properties.getProperty("dataSource.user");
		String Password = properties.getProperty("dataSource.password");
		
		System.out.println(jdbcUrl);
		System.out.println(User);
		System.out.println(Password);
		
		HikariConfig con = new HikariConfig();
		String DriverClass = "com.mysql.cj.jdbc.Driver";
		con.setDriverClassName(DriverClass);
		con.setJdbcUrl(jdbcUrl);
		con.setUsername(User);
		con.setPassword(Password);
		try (HikariDataSource dataSource = new HikariDataSource(con)) {
			Connection connection = dataSource.getConnection();
			return connection;
		}
	}*/
	
	public static Connection getJdbcConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "E:\\Project_code\\Library_management\\src\\main\\java\\in\\ineuron\\properties\\dbinfo.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		properties.load(fis);

		String url = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("user");
	    String password =properties.getProperty("pass");
		/*String url1 = "jdbc:mysql://localhost:3306/lib_management";
		String username = "root";
		String password = "9844";*/

		return DriverManager.getConnection(url, username, password);
	}
	
	public static void cleanUp(Connection con, PreparedStatement pstmt, ResultSet resultSet) throws SQLException {
		// Step6. Close the resources
		if (con != null) {
			con.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
	
}
