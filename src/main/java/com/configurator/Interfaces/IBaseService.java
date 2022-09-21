package com.configurator.Services;

import java.sql.*; 
import org.sqlite.*; 
public class BaseService {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			  conn = DriverManager.getConnection("jdbc:sqlite:/DB/configurator.db");
		} catch (Exception e) {
			conn = null;
		}
		return conn;
	}
}
