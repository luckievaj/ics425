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

public class CustomerEdit {

	@SuppressWarnings("resource")
	public static void persistCustomer(Customer customer) { //<%cust.getCustomerId%>
//	public static void persistCustomer(Customer customer, Address address, Phone phone, Email email, Credentials credentials) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String customerInsert = 
					"UPDATE CUSTOMER SET FIRST_NAME WHERE CUSTOMER_ID=?";
//			String addressInsert = 
//					"INSERT INTO ADDRESS (STREET, CITY, STATE, ZIPCODE, CUSTOMER_ID VALUES (?, ?, ?, ?, ?)";
//			String phoneInsert =
//					"INSERT INTO PHONE (PHONE1, PHONE2, CUSTOMER_ID) VALUE (?, ?, ?)";
//			String emailInsert =
//					"INSERT INTO EMAIL (EMAIL1, EMAIL2, CUSTOMER_ID) VALUE (?, ?, ?)";
//			String credentialsInsert = 
//					"INSERT INTO CREDENTIALS (ANN_DATE1, ANN_DESC1, ANN_DATE2, ANN_DESC2, ANN_DATE3, ANN_DESC3, CUSTOMER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(customerInsert);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.executeUpdate();
			
			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
//				int i = rs.getInt(1);
//				
//				Address addr = customer.getAddress();
//
//				ps = conn.prepareStatement(addressInsert);
//				ps.setString(1, addr.getStreet());
//				ps.setString(2, addr.getCity());
//				ps.setString(3, addr.getState());
//				ps.setString(4, addr.getZipCode());
//				ps.setInt(5, i);
//				ps.executeUpdate();
//				
//				
//				Phone phn = customer.getPhone();
//				
//				ps = conn.prepareStatement(phoneInsert);
//				ps.setString(1,  phn.getPhone1());
//				ps.setString(2,  phn.getPhone2());
//				ps.setInt(3, i);
//				ps.executeUpdate();
//
//				
//				Email eml = customer.getEmail();
//				
//				ps = conn.prepareStatement(emailInsert);
//				ps.setString(1,  eml.getEmail1());
//				ps.setString(2,  eml.getEmail2());
//				ps.setInt(3, i);
//				ps.executeUpdate();
//
//				Credentials cred = customer.getCredentials();
//				
//				ps = conn.prepareStatement(credentialsInsert);
//				ps.setString(1,  cred.getAnnDate1());
//				ps.setString(2,  cred.getAnnDate1());
//				ps.setString(3,  cred.getAnnDate2());
//				ps.setString(4,  cred.getAnnDate2());
//				ps.setString(5,  cred.getAnnDate3());
//				ps.setString(6,  cred.getAnnDate3());
//				ps.setInt(7, i);
//				ps.executeUpdate();


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
			while (rs.next()) {
				Customer cust = new Customer();				
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
	
	
	/*
	 * getCustomerDetail()
	 * 
	 * this method will query the database for the specific customer passed through 
	 * from the button attached to the customer display line.
	 */
	public static List<Customer> getCustomerDetail() {
		Connection conn = null, connDS = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> custDetail = new ArrayList<Customer>();
//		Customer custDetail = new Customer();
		try {			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();				
			String selectAll = "SELECT * FROM CUSTOMER C INNER JOIN ADDRESS A ON C.ADDRESS_ID = A.ID INNER JOIN CREDENTIALS X ON C.CREDENTIALS_ID = X.ID";
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(selectAll);
			while (rs.next()) {
				Address addr  = new Address();
				Customer cust = new Customer();
				Credentials cred = new Credentials();
				Phone phone = new Phone();
				Email email = new Email();
				
				cust.setFirstName(rs.getString("FIRST_NAME"));
				cust.setLastName(rs.getString("LAST_NAME"));
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
				phone.setPhone1(rs.getString("PHONE1"));
				phone.setPhone2(rs.getString("PHONE2"));
				email.setEmail1(rs.getString("EMAIL1"));
				email.setEmail2(rs.getString("EMAIL2"));
				cust.setAddress(addr);
				cust.setCredentials(cred);
				cust.setPhone(phone);
				cust.setEmail(email);
				custDetail.add(cust);
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
		return custDetail;	
	}
	
	
}
