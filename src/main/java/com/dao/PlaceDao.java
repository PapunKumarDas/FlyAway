package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Airline;
import com.model.Place;

public class PlaceDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/admin?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin@12";
	
	// placeId, sourceCity, destinationCity;

	public PlaceDao() {
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

	public void insert(Place place) throws SQLException {
		
		// placeId, sourceCity, destinationCity;
		
		String INSERT_SQL = "INSERT INTO places" + "  (sourceCity,destinationCity) VALUES "
				+ " (?,?);";
	
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
			preparedStatement.setString(1, place.getSourceCity());
			preparedStatement.setString(2, place.getDestinationCity());
		
				
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			SqlException(e);
		}
	}

	public Place getByKey(int placeId) {
		
		
		String SELECT_BY = "select placeId,sourceCity,destinationCity from places where placeId =?";
		Place place = null;
	
		try (Connection connection = getConnection();		
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY);) {
			preparedStatement.setInt(1, placeId);
			System.out.println(preparedStatement);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String sourceCity  			= rs.getString("sourceCity");
				String destinationCity 		= rs.getString("destinationCity");
				
				place = new Place();			
				place.setPlaceId(placeId);
				place.setSourceCity(sourceCity);
				place.setDestinationCity(destinationCity);
				
				System.out.println(place.toString());
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return place;
	}

	public List<Place> listOfAll() {

		String SELECT_ALL = "select * from places";
		
		List<Place> places = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();


			while (rs.next()) {
				int	placeId				= rs.getInt("placeId");
				String sourceCity  		= rs.getString("sourceCity");
				String destinationCity 	= rs.getString("destinationCity");
				
				Place place = new Place();			
				place.setPlaceId(placeId);
				place.setSourceCity(sourceCity);
				place.setDestinationCity(destinationCity);
				
				places.add( place);
			}
		} catch (SQLException e) {
			SqlException(e);
		}
		return places;
	}

	
	public boolean delete(int placeId) throws SQLException {
		boolean status;
		
		String DELETE_SQL = "delete from places where placeId = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {
			preparedStatement.setInt(1, placeId);
			System.out.println(preparedStatement);
			
			status = preparedStatement.executeUpdate() > 0;
		}
		return status;
	}

	public boolean update(Place place) throws SQLException {
		boolean status;
		
		String UPDATE_SQL = "update places set sourceCity=?, destinationCity=? where placeId = ?;";

		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);) {
			System.out.println("updated places :"+preparedStatement);

			preparedStatement.setString(1, place.getSourceCity());
			preparedStatement.setString(2, place.getDestinationCity());
			preparedStatement.setInt(3, place.getPlaceId());
	
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
