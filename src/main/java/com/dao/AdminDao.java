package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.model.Customer;

public class AdminDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/admin?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin@12";
	
	
	// useName password 

	public AdminDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			System.out.println("Db details " + connection.toString());
			
		} catch (SQLException e) {
			// What to do // Debug
			e.printStackTrace();
			SqlException(e);
		} catch (ClassNotFoundException e) {
			// What to do // Debug
			e.printStackTrace();
		}
		return connection;
	}

	public void insert(Admin admin) throws SQLException {
		
		// 	userName password; 
		
		String INSERT_SQL = "INSERT INTO admin" + "  (userName,password) VALUES "
				+ " (?,?);";
	
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
			preparedStatement.setString(1, admin.getUserName());
			preparedStatement.setString(2, admin.getPassword());
				
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			SqlException(e);
		}
	}

	public Admin getByKey(String userName) {
		
		String SELECT_BY = "select password, userName from admin where userName =?";
		Admin admin = null;
	
		try (Connection connection = getConnection();		
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY);) {
			preparedStatement.setString(1, userName);
			System.out.println(preparedStatement);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String password = rs.getString("password");
				String auserName = rs.getString("userName");
				admin = new Admin();
				admin.setUserName(auserName);
				admin.setPassword(password);
				
				System.out.println(admin.toString());
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return admin;
	}

	public List<Admin> listOfAll() {

		String SELECT_ALL = "select * from admin";
		
		List<Admin> admins = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

		
			while (rs.next()) {
				
				String userName  = rs.getString("userName");
				String password  = rs.getString("password");
				
				Admin admin = new Admin(userName,password);
				admins.add( admin);
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return admins;
	}

	
	public boolean delete(String admin) throws SQLException {
		boolean status;
		
		String DELETE_SQL = "delete from admin where userName = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {
			preparedStatement.setString(1, admin);
			System.out.println(preparedStatement);
			
			status = preparedStatement.executeUpdate() > 0;
		}
		return status;
	}

	public boolean update(Admin admin) throws SQLException {
		boolean status;
		
		String UPDATE_SQL = "update admin set password=? where userName = ?;";

		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);) {
			System.out.println("updated admin :"+preparedStatement);

			preparedStatement.setString(1, admin.getPassword());
			preparedStatement.setString(2, admin.getUserName());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

			status = preparedStatement.executeUpdate() > 0;
		}
		return status;
	}

	private void SqlException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
