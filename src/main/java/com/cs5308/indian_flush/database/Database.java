package com.cs5308.indian_flush.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* @Author: Vikram */
public class Database {

	private static Connection CONNECTION = null;

	static String URL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_23_DEVINT";
	static String USER = "CSCI5308_23_DEVINT_USER";
	static String PASSWORD = "ieX6zeeje4ii7iep";
	static String JDBC_DRIVER_STRING = "com.mysql.jdbc.Driver";

	public static Connection instance() {

		if (CONNECTION == null) {
			try {
				Class.forName(JDBC_DRIVER_STRING);
				CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return CONNECTION;
	}
}
