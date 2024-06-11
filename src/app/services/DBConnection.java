package app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/ugmb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Ted2002@";

	private DBConnection() throws SQLException {
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

	public static DBConnection getUniqueInstance() throws SQLException {
		if (uniqueInstance == null) {
			uniqueInstance = new DBConnection();
		}
		return uniqueInstance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void reset() {
		uniqueInstance = null;
	}

	private Connection connection;
	private static DBConnection uniqueInstance;
}