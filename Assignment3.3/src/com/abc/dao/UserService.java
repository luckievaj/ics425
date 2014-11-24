package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.abc.model.Name;
import com.abc.util.DbUtil;

public class UserService {

	private Connection connection;

	public UserService() {
		connection = DbUtil.getConnection();
	}

	public void addUser(Name name) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(first_name,last_name,user_name) values (?, ?, ?)");
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
	
	public void updateUser(Name name) {
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

	public List<Name> getAllUsers() {
		List<Name> nameList = new ArrayList<Name>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				Name name = new Name();
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
	
	public Name getUserById(int userId) {
		Name user = new Name();
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