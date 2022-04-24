package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Airline;

public class AirlineDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/admin?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin@12";
	
	// airlineId,airlineName,code, capacity;

	public AirlineDao() {
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

	public void insert(Airline airline) throws SQLException {
		
		// airlineId,airlineName,code, capacity;
		
		String INSERT_SQL = "INSERT INTO airlines" + "  (airlineName,code,capacity) VALUES "
				+ " (?,?,?);";
	
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
			preparedStatement.setString(1, airline.getAirlineName());
			preparedStatement.setString(2, airline.getCode());
			preparedStatement.setInt(3, airline.getCapacity());
				
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			SqlException(e);
		}
	}

	public Airline getByKey(int airlineId) {
		
		
		String SELECT_BY = "select airlineId,airlineName,code, capacity from airlines where airlineId =?";
		Airline airline = null;
	
		try (Connection connection = getConnection();		
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY);) {
			preparedStatement.setInt(1, airlineId);
			System.out.println(preparedStatement);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String airlineName  = rs.getString("airlineName");
				String code = rs.getString("code");
				int	   capacity  = rs.getInt("capacity");
				airline = new Airline();
				airline.setAirlineId(airlineId);
				airline.setAirlineName(airlineName);
				airline.setCode(code);
				airline.setCapacity(capacity);
				
				System.out.println(airline.toString());
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return airline;
	}

	public List<Airline> listOfAll() {

		String SELECT_ALL = "select * from airlines";
		
		List<Airline> airlines = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();


			while (rs.next()) {
				int	   airlineId  	= rs.getInt("airlineId");
				String airlineName  = rs.getString("airlineName");
				String code 		= rs.getString("code");
				int	   capacity  	= rs.getInt("capacity");
				
				
				Airline airline = new Airline();
				airline.setAirlineId(airlineId);
				airline.setAirlineName(airlineName);
				airline.setCode(code);
				airline.setCapacity(capacity);
				
				airlines.add( airline);
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return airlines;
	}

	
	public boolean delete(int airlineId) throws SQLException {
		boolean status;
		
		String DELETE_SQL = "delete from airlines where airlineId = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {
			preparedStatement.setInt(1, airlineId);
			System.out.println(preparedStatement);
			
			status = preparedStatement.executeUpdate() > 0;
		}
		return status;
	}

	public boolean update(Airline airline) throws SQLException {
		boolean status;
		
		String UPDATE_SQL = "update airlines set airlineName=?, code=?, capacity=? where airlineId = ?;";

		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);) {
			System.out.println("updated airlines :"+preparedStatement);

			preparedStatement.setString(1, airline.getAirlineName());
			preparedStatement.setString(2, airline.getCode());
			preparedStatement.setInt(3, airline.getCapacity());
			preparedStatement.setInt(4, airline.getAirlineId());
			
			
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

