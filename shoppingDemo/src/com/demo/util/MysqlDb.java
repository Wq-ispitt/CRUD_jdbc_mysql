package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDb {

	public MysqlDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String username = "root";
		String password = "root1234";
		return DriverManager.getConnection(dbURL, username, password);
	}

}
