package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/Estoque?" +
									  "userTimezone=true" +
									  "&serverTimezone=UTC";
	private static final String USER = "java";
	private static final String PASS = "java";
	private static final String URLsqlite = "jdbc:sqlite:" +
				"D:/Projects/GitHub/JavaProgrammer/Estoque/db/Estoque.DB";

	public static Connection getConnection() {
		Connection con = null;
		try {
			//con = DriverManager.getConnection(URL, USER, PASS);
			con = DriverManager.getConnection(URLsqlite);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
