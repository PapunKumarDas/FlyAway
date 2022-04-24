package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

public class CustomerDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/admin?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin@12";
	
	
	// custId  firstName  lastName  emailId  phoneNo  password 

	public CustomerDao() {
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

	public void insert(Customer customer) throws SQLException {
		
		// `custId`  `firstName`  `lastName` `emailId` `password` 
		
		String INSERT_SQL = "INSERT INTO customer" + "  (firstName, lastName, emailId, phoneNo, password) VALUES "
				+ " (?,?,?,?,?);";
	
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmailId());
			preparedStatement.setString(4, customer.getPhoneNo());
			preparedStatement.setString(5, customer.getPassword());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			SqlException(e);
		}
	}

	public Customer getByKey(int custId) {
		
		String SELECT_BY = "select firstName, lastName, emailId, phoneNo, password from customer where custId =?";
		Customer customer = null;
	
		try (Connection connection = getConnection();		
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY);) {
			preparedStatement.setInt(1, custId);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				//String customerId 	= rs.getString("custId");
				String firstName= rs.getString("firstName");
				String lastName	= rs.getString("lastName");
				String emailId 	= rs.getString("emailId");
				String phoneNo 	= rs.getString("phoneNo");
				String password = rs.getString("password");

				
				customer = new Customer();
				
				customer.setCustId(custId);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmailId(emailId);
				customer.setPhoneNo(phoneNo);
				customer.setPassword(password);
				
				System.out.println(customer.toString());
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return customer;
	}

public Customer getByKey(String aemailId) {
		
		String SELECT_BY = "select custId, firstName, lastName, emailId, phoneNo, password from customer where emailId =?";
		Customer customer = null;
	
		try (Connection connection = getConnection();		
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY);) {
			preparedStatement.setString(1, aemailId);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int custId 		= rs.getInt("custId");
				String firstName= rs.getString("firstName");
				String lastName	= rs.getString("lastName");
				String emailId 	= rs.getString("emailId");
				String phoneNo 	= rs.getString("phoneNo");
				String password = rs.getString("password");

				
				customer = new Customer();
			
				customer.setCustId(custId);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmailId(emailId);
				customer.setPhoneNo(phoneNo);
				customer.setPassword(password);
				
				System.out.println(customer.toString());
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return customer;
	}

	
	
	
	public List<Customer> listOfAll() {

		String SELECT_ALL = "select * from customer";
		
		List<Customer> customers = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

	
			while (rs.next()) {
				
				String custId    = rs.getString("custId");
				String firstName = rs.getString("firstName");
				String lastName	 = rs.getString("lastName");
				String emailId 	 = rs.getString("emailId");
				String phoneNo 	 = rs.getString("phoneNo");
				String password  = rs.getString("password");
				
				Customer customer = new Customer(Integer.parseInt(custId),firstName,lastName,emailId,phoneNo,password);
				customers.add( customer);
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return customers;
	}

		
	
	
	public boolean delete(int custId) throws SQLException {
		boolean status;
		
		String DELETE_SQL = "delete from customer where custId = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {
			preparedStatement.setInt(1, custId);
			System.out.println(preparedStatement);
			
			status = preparedStatement.executeUpdate() > 0;
		}
		return status;
	}

	public boolean update(Customer customer) throws SQLException {
		boolean status;
		
		String UPDATE_SQL = "update customer set firstName=?, lastName=?, emailId=?,phoneNo=?,password=? where custId = ?;";

		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);) {
			System.out.println("updated customer :"+preparedStatement);

			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmailId());
			preparedStatement.setString(4, customer.getPhoneNo());
			preparedStatement.setString(5, customer.getPassword());	
			preparedStatement.setInt(6, customer.getCustId());
			
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
