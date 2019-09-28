package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection() throws SQLException {
		String jdbc_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(db_url, "LJ", "1234");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}