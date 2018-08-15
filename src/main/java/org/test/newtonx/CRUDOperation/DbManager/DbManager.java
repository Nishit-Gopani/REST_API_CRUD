package org.test.newtonx.CRUDOperation.DbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	public static final String URL = "jdbc:mysql://localhost:3306/NEWTONX_TEST?useSSL=false";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	static Connection connection;

	public DbManager() {
	}

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
	}
}
