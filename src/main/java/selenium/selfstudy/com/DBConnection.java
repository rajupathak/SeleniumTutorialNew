package selenium.selfstudy.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public Statement stmt;
	public Connection con;

	public Statement getStatement() {

		String driver = "com.mysql.cj.jdbc.Driver";
		String connection = "jdbc:mysql://localhost:3306/selenium";
		String userName = "root";
		String passWord = "root";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(connection, userName, passWord);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return stmt;

	}

	public void insertData(String query) throws SQLException {

		Statement stm = getStatement();
		System.out.println(stm);

		stm.executeUpdate(query);
	}

	public ResultSet getData(String query) throws SQLException {
		Statement stm = getStatement();
		ResultSet result = stm.executeQuery(query);
		return result;
	}

}
