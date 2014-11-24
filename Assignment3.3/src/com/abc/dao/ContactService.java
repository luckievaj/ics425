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
	
	public void updateContact(ContactName contactName) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update contact set first_name=?, last_name=?" +
							"where contact_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, contactName.getFirstName());
			preparedStatement.setString(2, contactName.getLastName());
			preparedStatement.setInt(3, contactName.getContactId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ContactName> getAllContacts() {
		List<ContactName> contactList = new ArrayList<ContactName>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from contact");
			while (rs.next()) {
				ContactName contactName = new ContactName();
				contactName.setContactId(rs.getInt("contact_id"));
				contactName.setFirstName(rs.getString("first_name"));
				contactName.setLastName(rs.getString("last_name"));
				contactList.add(contactName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contactList;
	}
	
	public ContactName getContactById(int contactId) {
		ContactName contact = new ContactName();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from contact where contact_id=?");
			preparedStatement.setInt(1, contactId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				contact.setContactId(rs.getInt("contact_id"));
				contact.setFirstName(rs.getString("first_name"));
				contact.setLastName(rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contact;
	}
}
