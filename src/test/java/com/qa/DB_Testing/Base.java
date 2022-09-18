package com.qa.DB_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public static Connection connection;
	
	@BeforeTest
	public Connection setUp() throws SQLException {
	String durl = "jdbc:mysql://localhost:3306/emp_db_testing";
	String username = "root";
	String password = "root";
	connection = DriverManager.getConnection(durl, username, password);
	return connection;
	}
	
	@AfterTest
	public void tearDown() throws SQLException {
		connection.close();
	}
}
