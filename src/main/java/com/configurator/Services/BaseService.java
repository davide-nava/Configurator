package com.configurator.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public abstract class BaseService   {

	private static String connUrl = "jdbc:sqlite:/DB/configurator.db";

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(connUrl);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return conn;
	}


	protected void deleteExecute(String table, String pk , UUID id) throws SQLException {
		Connection con = null;

		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from " + table + " where " + pk	 + "=? ");
			ps.setString(1, id.toString());

			ps.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (con != null)
				con.close();
		}
	}

	public static void printSQLException(SQLException ex) {
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

	public abstract void delete(UUID id);
}
