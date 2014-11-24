package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.abc.model.ContactName;
import com.abc.util.DbUtil;

public class UserService {

	private Connection connection;

	public UserService() {
		connection = DbUtil.getConnection();
	}

	public void addUser(ContactName name) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user (first_name,last_name,user_name) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, name.getFirstName());
			preparedStatement.setString(2, name.getLastName());
			preparedStatement.setString(3, name.getUserName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where user_id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(ContactName name) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set first_name=?, last_name=?, user_name=?" +
							"where user_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, name.getFirstName());
			preparedStatement.setString(2, name.getLastName());
			preparedStatement.setString(3, name.getUserName());
			preparedStatement.setInt(4, name.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ContactName> getAllUsers() {
		List<ContactName> nameList = new ArrayList<ContactName>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				ContactName name = new ContactName();
				name.setUserid(rs.getInt("userid"));
				name.setFirstName(rs.getString("firstname"));
				name.setLastName(rs.getString("lastname"));
				name.setUserName(rs.getString("username"));
				nameList.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nameList;
	}
	
	public ContactName getUserById(int userId) {
		ContactName user = new ContactName();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from user where user_id=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUserName(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
