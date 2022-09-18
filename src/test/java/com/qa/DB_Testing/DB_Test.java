package com.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base {
	
	@Test
	public void getTableData() throws SQLException {
		connection = this.setUp();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee");
		while(resultSet.next()) {
			String name = resultSet.getString(1);
			String age = resultSet.getString(2);
			System.out.println(name +" "+ age);
		}
	}
	
	@Test
	public void insertData() throws SQLException {
		connection = this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(name, age)values(?,?)");
		preparedStatement.setString(1, "Pooja");
		preparedStatement.setInt(2, 23);
		preparedStatement.executeUpdate();
		getTableData();
	}
	
	@Test
	public void deleteData() throws SQLException {
		connection =this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where name = 'Pooj'");
		//PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where name = ?");
		//preparedStatement.setString(1, "Nick");
		preparedStatement.executeUpdate();
		getTableData();
	}
	
	@Test
	public void updateData() throws SQLException {
		connection = this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("update employee set age = 20 where name = 'Bill'");
		preparedStatement.executeUpdate();
		getTableData();
	}
}
