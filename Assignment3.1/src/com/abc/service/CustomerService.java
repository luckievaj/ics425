package com.abc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.abc.model.Address;
import com.abc.model.Credentials;
import com.abc.model.Customer;
import com.abc.model.Email;
import com.abc.model.Phone;

public class CustomerService {


	/*
	 * persistCustomer()
	 * 
	 * This method writes to the DB the variables passed through from the servlet.
	 */
	public static void persistCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			Address address = customer.getAddress();
			Phone phone = customer.getPhone();
			Email email = customer.getEmail();
			Credentials credentials = customer.getCredentials();
		
			String customerInsert = 
					"INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME) VALUES (?, ?)";
			String credInsert = 
					"INSERT INTO CREDENTIALS (ANN_DATE_1, ANN_DESC_1, ANN_DATE_2, ANN_DESC_2, ANN_DATE_3, ANN_DESC_3, CUSTOMER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
			String emailInsert = 
					"INSERT INTO EMAIL (EMAIL1, EMAIL2, CUSTOMER_ID) VALUES (?, ?, ?)";
			String phoneInsert = 
					"INSERT INTO PHONE (PHONE1, PHONE2, CUSTOMER_ID) VALUES (?, ?, ?)";
			String addInsert = 
					"INSERT INTO ADDRESS (STREET, CITY, STATE, ZIPCODE, CUSTOMER_ID) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(customerInsert);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.executeUpdate();

			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
				int i = rs.getInt(1);
				ps = conn.prepareStatement(addInsert);
				ps.setString(1, address.getStreet());
				ps.setString(2, address.getCity());
				ps.setString(3, address.getState());
				ps.setString(4, address.getZipCode());
				ps.setInt(5, i);
				ps.executeUpdate();

				ps = conn.prepareStatement(phoneInsert);
				ps.setString(1, phone.getPhone1());
				ps.setString(2, phone.getPhone2());
				ps.setInt(3, i);
				ps.executeUpdate();

				ps = conn.prepareStatement(emailInsert);
				ps.setString(1, email.getEmail1());
				ps.setString(2, email.getEmail2());
				ps.setInt(3, i);
				ps.executeUpdate();

				ps = conn.prepareStatement(credInsert);
				ps.setString(1, credentials.getAnnDate1());
				ps.setString(2, credentials.getAnnDesc1());
				ps.setString(3, credentials.getAnnDate2());
				ps.setString(4, credentials.getAnnDesc2());
				ps.setString(5, credentials.getAnnDate3());
				ps.setString(6, credentials.getAnnDesc3());
				ps.setInt(7, i);
				ps.executeUpdate();

			} else {
				throw new IllegalStateException("Unable to retrieve last insert id");
			}	
			conn.commit();
		} catch (Exception e) {
			if (null != conn) {
				try {
					conn.rollback();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) ps.close();
				if (null != conn) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	//******************************************************************

	/*
	 * editCustomer()
	 * 
	 * This method writes to the DB the variables passed through from the servlet.
	 */
	public static void editCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String customerEdit = 
					"UPDATE CUSTOMER SET FIRST_NAME=?, LAST_NAME=?" + "WHERE CUSTOMER_ID=?";
			String addEdit = 
					"UPDATE ADDRESS SET STREET=?, CITY=?, STATE=?, ZIPCODE=?" + "WHERE CUSTOMER_ID=?";
			String phoneEdit = 
					"UPDATE PHONE SET PHONE1=?, PHONE2=?"+"WHERE CUSTOMER_ID=?";
			String emailEdit = 
					"UPDATE EMAIL SET EMAIL1=?, EMAIL2=?"+"WHERE CUSTOMER_ID=?";
			String credInsert = 
					"UPDATE CREDENTIALS SET ANN_DATE_1=?, ANN_DESC_1=?, ANN_DATE_2=?, ANN_DESC_2=?, ANN_DATE_3=?, ANN_DESC_3=?" + "WHERE CUSTOMER_ID=?";
			
			ps = conn.prepareStatement(credInsert);
			ps.setString(1, customer.credentials.getAnnDate1());
			ps.setString(2, customer.credentials.getAnnDesc1());
			ps.setString(3, customer.credentials.getAnnDate2());
			ps.setString(4, customer.credentials.getAnnDesc2());
			ps.setString(5, customer.credentials.getAnnDate3());
			ps.setString(6, customer.credentials.getAnnDesc3());
			ps.setInt(7, customer.getCustomerID());
			ps.executeUpdate();

			ps = conn.prepareStatement(emailEdit);
			ps.setString(1, customer.email.getEmail1());
			ps.setString(2, customer.email.getEmail2());
			ps.setInt(3, customer.getCustomerID());			
			ps.executeUpdate();

			ps = conn.prepareStatement(phoneEdit);
			ps.setString(1, customer.phone.getPhone1());
			ps.setString(2, customer.phone.getPhone2());
			ps.setInt(3, customer.getCustomerID());
			ps.executeUpdate();

	
			ps = conn.prepareStatement(addEdit);
			ps.setString(1, customer.address.getStreet());
			ps.setString(2, customer.address.getCity());
			ps.setString(3, customer.address.getState());
			ps.setString(4, customer.address.getZipCode());
			ps.setInt(5, customer.getCustomerID());
			ps.executeUpdate();

			ps = conn.prepareStatement(customerEdit);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getCustomerID());
			ps.executeUpdate();

			
			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {

			} else {
				throw new IllegalStateException("Unable to retrieve last insert id");
			}	
			conn.commit();
		} catch (Exception e) {
			if (null != conn) {
				try {
					conn.rollback();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) ps.close();
				if (null != conn) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//******************************************************************

	/*
	 * deleteCustomer()
	 * 
	 * This method writes to the DB the variables passed through from the servlet.
	 */
	public static void deleteCustomer(int customerID) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String customerDelete = 
					"DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";
			String addressDelete = 
					"DELETE FROM ADDRESS WHERE CUSTOMER_ID=?";
			String phoneDelete = 
					"DELETE FROM PHONE WHERE CUSTOMER_ID=?";
			String emailDelete = 
					"DELETE FROM EMAIL WHERE CUSTOMER_ID=?";
			String credentialsDelete = 
					"DELETE FROM CREDENTIALS WHERE CUSTOMER_ID=?";
			
			ps = conn.prepareStatement(customerDelete);
			ps.setInt(1, customerID);
			ps.executeUpdate();
			ps = conn.prepareStatement(addressDelete);
			ps.setInt(1, customerID);
			ps.executeUpdate();
			ps = conn.prepareStatement(phoneDelete);
			ps.setInt(1, customerID);
			ps.executeUpdate();
			ps = conn.prepareStatement(emailDelete);
			ps.setInt(1, customerID);
			ps.executeUpdate();
			ps = conn.prepareStatement(credentialsDelete);
			ps.setInt(1, customerID);
			ps.executeUpdate();

			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {

			} else {
				throw new IllegalStateException("Unable to retrieve last insert id");
			}	
			conn.commit();
		} catch (Exception e) {
			if (null != conn) {
				try {
					conn.rollback();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) ps.close();
				if (null != conn) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//******************************************************************


	/*
	 * getAllCustomers()
	 * 
	 * This method will query the database and return a list of all found customers.
	 * It will display the first and last name with three buttons (view, edit, delete).
	 */
	public static List<Customer> getAllCustomers() {
		Connection conn = null, connDS = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> custList = new ArrayList<Customer>();
		try {			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();				
			String selectAll = "SELECT * FROM CUSTOMER";
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(selectAll);

			//Loop through the DB and add to the array list.
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerID(rs.getInt("CUSTOMER_ID"));
				cust.setFirstName(rs.getString("FIRST_NAME"));
				cust.setLastName(rs.getString("LAST_NAME"));
				custList.add(cust);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) ps.close();
				if (null != conn) conn.close();
				if (null != connDS) connDS.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return custList;		
	}

	//******************************************************************


	/*
	 * getCustomerDetail()
	 * 
	 * this method will query the database for the specific customer passed through 
	 * from the button attached to the customer display line.
	 */
	public static Customer getCustomerDetail(int custId) { //needs to pass in an object with Customer_ID
		Connection conn = null, connDS = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		//should an array be created here?
		Customer custDetail = new Customer(custId, null, null, null, null, null, null);
		try {			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();		

			//need to update the ? with passed in customer_ID		
			String selectCustomer = "SELECT ? FROM CUSTOMER C INNER JOIN ADDRESS A ON C.ADDRESS_ID = A.ID "
					+ "INNER JOIN PHONE P ON C.CUSTOMER_ID = P.CUSTOMER_ID"
					+ "INNER JOIN EMAIL E ON C.CUSTOMER_ID = E.CUSTOMER_ID"
					+ "INNER JOIN CREDENTIALS X ON C.CUSTOMER_ID = X.CUSTOMER_ID";

			stmt = conn.createStatement();
			rs  = stmt.executeQuery(selectCustomer);
			
			//Instantiate temp objects
			Customer cust = new Customer();
			Address addr  = new Address();
			Credentials cred = new Credentials();
			Phone phone = new Phone();
			Email email = new Email();
			
			//retrieve from DB set to variable
			cust.setCustomerID(rs.getInt("CUSTOMER_ID"));
			cust.setFirstName(rs.getString("FIRST_NAME"));
			cust.setLastName(rs.getString("LAST_NAME"));
			addr.setStreet(rs.getString("STREET"));
			addr.setCity(rs.getString("CITY"));
			addr.setState(rs.getString("STATE"));
			addr.setZipCode(rs.getString("ZIPCODE"));
			phone.setPhone1(rs.getString("PHONE1"));
			phone.setPhone2(rs.getString("PHONE2"));
			email.setEmail1(rs.getString("EMAIL1"));
			email.setEmail2(rs.getString("EMAIL2"));
			cred.setAnnDate1(rs.getString("ANN_DATE1"));
			cred.setAnnDate1(rs.getString("ANN_DESC1"));
			cred.setAnnDate2(rs.getString("ANN_DATE2"));
			cred.setAnnDate2(rs.getString("ANN_DESC2"));
			cred.setAnnDate3(rs.getString("ANN_DATE3"));
			cred.setAnnDate3(rs.getString("ANN_DESC3"));
			
			//add variables to object
			custDetail.setCustomerID(custId);
//			custDetail.setFirstName(firstName);
//			custDetail.setLastName(lastName);
			custDetail.setAddress(addr);
			custDetail.setPhone(phone);
			custDetail.setEmail(email);
			custDetail.setCredentials(cred);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) ps.close();
				if (null != conn) conn.close();
				if (null != connDS) connDS.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return custDetail;	
	}
}
