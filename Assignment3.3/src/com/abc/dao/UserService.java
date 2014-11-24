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

	public void addUser(Name user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(firstname,lastname,username) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(Name user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set firstname=?, lastname=?, username=?" +
							"where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setInt(4, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Name> getAllUsers() {
		List<Name> users = new ArrayList<Name>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				Name user = new Name();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUserName(rs.getString("username"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public Name getUserById(int userId) {
		Name user = new Name();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from users where userid=?");
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
