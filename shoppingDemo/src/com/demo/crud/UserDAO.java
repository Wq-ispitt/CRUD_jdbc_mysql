package com.demo.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.util.MysqlDb;

public class UserDAO {
	
	MysqlDb db =  new MysqlDb();

	public User getUser(String name, String password) {
		User user = null;

		String sql = "select * from users where name = ? and password = ?";
		try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setPassword(password);
				user.setName(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public static void main(String[] args) {

		System.out.println(new UserDAO().getUser("user", "password").getName());

	}

}
