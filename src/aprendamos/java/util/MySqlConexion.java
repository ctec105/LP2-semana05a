package aprendamos.java.util;

import java.sql.*;

public class MySqlConexion {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection obtenerConexion() {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jugando?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

}