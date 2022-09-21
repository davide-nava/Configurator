package com.configurator.Services;

import com.configurator.Interfaces.IBaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseService implements IBaseService {

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

	protected void updateExecute(String sql, PreparedStatement ps) {
		Connection con = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			ps.executeUpdate();

		} catch (SQLException exception) {
			printSQLException(exception);
		} finally {
			if (rs != null)
				rs.close();

			if (con != null)
				con.close();
		}
	}

	protected void deleteExecute(String sql, UUID id) {
		Connection con = null;

		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id.toString());

			ps.executeUpdate();

		} catch (SQLException exception) {
			printSQLException(exception);
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

}
