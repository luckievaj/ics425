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

	private static Connection connection;

	public ContactService() {
		connection = DbUtil.getConnection();
	}

	public void addContact(ContactName name) {  //DONE??
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
	
	public void deleteContact(int contactId) {  //DONE??
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
	
	public void updateContact(ContactName contactName) { //DONE??
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
	
	public void addAddress(Address address) {	// Done??
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into contact (street,city,state,zipcode) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getState());
			preparedStatement.setString(4, address.getZipCode());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAddress(Address add) {  // Done??
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update contact set street=?, city=?, state=?, zipCode=?" + 
							"where contact_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, add.getStreet());
			preparedStatement.setString(2, add.getCity());
			preparedStatement.setString(3, add.getState());
			preparedStatement.setString(4, add.getZipCode());
			preparedStatement.setInt(5, add.getContactId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addPhone(Phone phone) {	// Done??
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into phone (phone1,phone2) values (?, ?, )");
			// Parameters start with 1
			preparedStatement.setString(1, phone.getPhone1());
			preparedStatement.setString(2, phone.getPhone2());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePhone(Phone updatePhone) {  // Done??
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update phone set phone1=?, phone2=?"  + 
							"where contact_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, updatePhone.getPhone1());
			preparedStatement.setString(2, updatePhone.getPhone2());
			preparedStatement.setInt(3, updatePhone.getContactId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addEmail(Email email) {	// Done
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into email (email1,email2) values (?, ?, )");
			// Parameters start with 1
			preparedStatement.setString(1, email.getEmail1());
			preparedStatement.setString(2, email.getEmail2());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmail(Email updateEmail) {	// Done
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into email (email1,email2) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, updateEmail.getEmail1());
			preparedStatement.setString(2, updateEmail.getEmail2());
			preparedStatement.setInt(3, updateEmail.getContactId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCredentials(Credentials credentials) {	// Done
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into crdentials (Ann_Date_1,Ann_Desc_1,Ann_Date_2,Ann_Desc_2,Ann_Data_3,Ann_Desc_3) "
							+ "values (?, ?, ?, ?, ?, ?, )");
			// Parameters start with 1
			preparedStatement.setString(1, credentials.getAnnDate1());
			preparedStatement.setString(2, credentials.getAnnDesc2());
			preparedStatement.setString(3, credentials.getAnnDate2());
			preparedStatement.setString(4, credentials.getAnnDesc2());
			preparedStatement.setString(5, credentials.getAnnDate3());
			preparedStatement.setString(6, credentials.getAnnDesc2());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCredentials(Credentials cred) {	// Done
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update credentials set Ann_Date_1=?, Ann_Desc_1=?, Ann_Date_2=?, Ann_Desc_2=?, Ann_Date_3=?, Ann_Desc_3=?");
			// Parameters start with 1
			preparedStatement.setString(1, cred.getAnnDate1());
			preparedStatement.setString(2, cred.getAnnDesc2());
			preparedStatement.setString(3, cred.getAnnDate2());
			preparedStatement.setString(4, cred.getAnnDesc2());
			preparedStatement.setString(5, cred.getAnnDate3());
			preparedStatement.setString(6, cred.getAnnDesc2());
			preparedStatement.setInt(7, cred.getContactId());
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
			} while (rs.next()) {
				Address address = new Address();
				address.setContactId(rs.getInt("contact_id"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setZipCode(rs.getString("zipCode"));
				contactList.add(address); // NEED TO BE FIXED
			} while (rs.next()) {
				Phone phone = new Phone();
				phone.setContactId(rs.getInt("contact_id"));
				phone.setPhone1(rs.getString("phone1"));
				phone.setPhone2(rs.getString("phone2"));
				contactList.add(phone); // NEED TO BE FIXED
			} while (rs.next()) {
				Email email = new Email();
				email.setContactId(rs.getInt("contact_id"));
				email.setEmail1(rs.getString("email1"));
				email.setEmail2(rs.getString("email2"));
				contactList.add(email); // NEED TO BE FIXED
			} while (rs.next()) {
				Credentials cred = new Credentials();
				cred.setContactId(rs.getInt("contact_id"));
				cred.setAnnDate1(rs.getString("anndate1"));
				cred.setAnnDesc1(rs.getString("anndesc1"));
				cred.setAnnDate2(rs.getString("anndate2"));
				cred.setAnnDesc2(rs.getString("anndesc2"));
				cred.setAnnDate3(rs.getString("anndate3"));
				cred.setAnnDesc3(rs.getString("anndesc3"));
				contactList.add(cred); // NEED TO BE FIXED
				
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
