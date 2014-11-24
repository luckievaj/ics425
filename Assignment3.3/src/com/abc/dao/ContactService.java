package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.abc.model.*;
import com.abc.util.DbUtil;

public class ContactService {

	private Connection connection;

	public ContactService() {
		connection = DbUtil.getConnection();
	}

	public void addContact(ContactName name) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into contact (first_name,last_name) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, name.getFirstName());
			preparedStatement.setString(2, name.getLastName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteContact(int contactId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from contact where contact_id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, contactId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateContact(Name name) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update contact set first_name=?, last_name=?, contact_name=?" +
							"where contact_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, name.getFirstName());
			preparedStatement.setString(2, name.getLastName());
			preparedStatement.setString(3, name.getContactName());
			preparedStatement.setInt(4, name.getContactId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Name> getAllContacts() {
		List<Name> nameList = new ArrayList<Name>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from contact");
			while (rs.next()) {
				Name name = new Name();
				name.setContactId(rs.getInt("contactid"));
				name.setFirstName(rs.getString("firstname"));
				name.setLastName(rs.getString("lastname"));
				nameList.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nameList;
	}
	
	public Name getContactById(int contactId) {
		Name contact = new Name();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from contact where contact_id=?");
			preparedStatement.setInt(1, contactId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				contact.setContactId(rs.getInt("contactid"));
				contact.setFirstName(rs.getString("firstname"));
				contact.setLastName(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contact;
	}
}
