package com.setDeals.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.setDeals.data.SetDealsRequest;



public class SetDealsDao {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@10.20.202.183:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "system";


	public void insertRecordIntoTable(SetDealsRequest request) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO DEAL_DETAILS"
				+ "(SHOPNAME,SHOPCONTACTNUM,DISCOUNT,DESCRIPTION,STARTDATE,ENDDATE) values "
				+ "(?,to_number(?),?,?,(?),(?))";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, request.getShopName());
			preparedStatement.setLong(2, request.getShopContactNum());
			preparedStatement.setString(3, request.getSaleDetails().getDiscount().toString());
			preparedStatement.setString(4, request.getSaleDetails().getDescription());
			preparedStatement.setDate(5, request.getSaleDates().getStartDate());
			preparedStatement.setDate(6, request.getSaleDates().getEndDate());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DEAL_DETAILS table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw e;

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}


}
