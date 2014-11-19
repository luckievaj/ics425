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

public class CustomerDelete {

	@SuppressWarnings("resource")
	public static void persistCustomer(Customer customer) {
//	public static void persistCustomer(Customer customer, Address address, Credentials credentials) {
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
					"DELETE INTO ADDRESS WHERE CUSTOMER_ID=?";
			String phoneDelete = 
					"DELETE INTO PHONE WHERE CUSTOMER_ID=?";
			String emailDelete = 
					"DELETE INTO EMAIL WHERE CUSTOMER_ID=?";
			String credentialsDelete = 
					"DELETE INTO CREDENTIALS WHERE CUSTOMER_ID=?";

			Address addr = customer.getAddress();

			ps = conn.prepareStatement(addressDelete);
			ps.setString(1, addr.getStreet());
			ps.setString(2, addr.getCity());
			ps.setString(3, addr.getState());
			ps.setString(4, addr.getZipCode());
			ps.executeUpdate();
			
			Phone phn = customer.getPhone();
			
			ps = conn.prepareStatement(phoneDelete);
			ps.setString(1,  phn.getPhone1());
			ps.setString(2,  phn.getPhone2());
			ps.executeUpdate();

			Email eml = customer.getEmail();
			
			ps = conn.prepareStatement(emailDelete);
			ps.setString(1,  eml.getEmail1());
			ps.setString(2,  eml.getEmail2());
			ps.executeUpdate();
			
			Credentials cred = customer.getCredentials();
			
			ps = conn.prepareStatement(credentialsDelete);
			ps.setString(1,  cred.getAnnDate1());
			ps.setString(2,  cred.getAnnDesc1());
			ps.setString(3,  cred.getAnnDate2());
			ps.setString(4,  cred.getAnnDesc2());
			ps.setString(5,  cred.getAnnDate3());
			ps.setString(6,  cred.getAnnDesc3());
			
			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
//				int i = rs.getInt(1);
				ps = conn.prepareStatement(customerDelete);
				ps.setString(1, customer.getFirstName());
				ps.setString(2, customer.getLastName());
//				ps.setInt(3, i);
//				ps.setInt(4, i);
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
}