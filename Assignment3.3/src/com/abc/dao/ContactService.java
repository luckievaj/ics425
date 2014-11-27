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
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contactList;
	}
	
	public Contact getContactById(int contactId) {
		Contact contact = new Contact();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM CONTACT C INNER JOIN ADDRESS A ON C.CONTACT_ID = A.CONTACT_ID INNER JOIN PHONE P ON C.CONTACT_ID=P.CONTACT_ID INNER JOIN EMAIL E ON C.CONTACT_ID=E.CONTACT_ID INNER JOIN CREDENTIALS X ON C.CONTACT_ID = X.CONTACT_ID");
			preparedStatement.setInt(1, contactId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				Address addr  = new Address();
				Credentials cred = new Credentials();
				Phone phn = new Phone();
				Email eml = new Email();
				
				contact.setContactId(rs.getInt("CONTACT_ID"));
				contact.setFirstName(rs.getString("FIRST_NAME"));
				contact.setLastName(rs.getString("LAST_NAME"));
				addr.setStreet(rs.getString("STREET"));
				addr.setCity(rs.getString("CITY"));
				addr.setState(rs.getString("STATE"));
				addr.setZipCode(rs.getString("ZIPCODE"));
				cred.setAnnDate1(rs.getString("ANN_DATE1"));
				cred.setAnnDate1(rs.getString("ANN_DESC1"));
				cred.setAnnDate2(rs.getString("ANN_DATE2"));
				cred.setAnnDate2(rs.getString("ANN_DESC2"));
				cred.setAnnDate3(rs.getString("ANN_DATE3"));
				cred.setAnnDate3(rs.getString("ANN_DESC3"));
				phn.setPhone1(rs.getString("PHONE1"));
				phn.setPhone2(rs.getString("PHONE2"));
				eml.setEmail1(rs.getString("EMAIL1"));
				eml.setEmail2(rs.getString("EMAIL2"));
				contact.setAddress(addr);
				contact.setPhone(phn);
				contact.setEmail(eml);
				contact.setCredentials(cred);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contact;
	}
}
