package com.demo.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.util.MysqlDb;

public class ProductsDAO implements DAO {
	
	MysqlDb db =  new MysqlDb();

	public int getTotal() {
		int total = 0;
		try (Connection conn = db.getConnection(); Statement st = conn.createStatement()) {
			String sql = "select count(*) from products";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("total : " + total);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	@Override
	public void add(Products pro) {
		String sql = "insert into products values(null, ?, ?, ?, ?)";
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, pro.name);
			ps.setDouble(2, pro.price);
			ps.setInt(3, pro.categoryId);
			ps.setInt(4, pro.modelYear);

			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				pro.setId(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Products pro) {
		String sql = "update products set p_name = ?, p_price = ?, category_id = ?, model_year = ?";
		try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, pro.name);
			ps.setDouble(2, pro.price);
			ps.setInt(3, pro.categoryId);
			ps.setInt(4, pro.modelYear);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from products where p_id = " + id;
		try (Connection conn = db.getConnection(); Statement st = conn.createStatement()) {
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Products get(int id) {
		Products pro = null;
		String sql = "select * from products where p_id = " + id;
		try (Connection conn = db.getConnection(); Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				pro = new Products();

				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int cateId = rs.getInt(4);
				int modelY = rs.getInt(5);

				pro.setName(name);
				pro.setPrice(price);
				pro.setCategoryId(cateId);
				pro.setModelYear(modelY);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pro;
	}

	@Override
	public List<Products> view() {

		return viewRange(0, 100);
	}

	@Override
	public List<Products> viewRange(int start, int count) {
		List<Products> products = new ArrayList<>();
		String sql = "select * from products order by p_id asc limit ?, ?";
		try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Products pro = new Products();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int cateID = rs.getInt(4);
				int modelY = rs.getInt(5);

				pro.setId(id);
				pro.setName(name);
				pro.setPrice(price);
				pro.setCategoryId(cateID);
				pro.setModelYear(modelY);

				products.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

}
