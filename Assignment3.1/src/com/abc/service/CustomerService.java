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
import com.abc.model.Customer;

public class CustomerService {

	public static void persistCustomer(Customer customer, Address address) {
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
					"INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ADDRESS_ID) VALUES (?, ?, ?, ?)";
			String addressInsert = 
					"INSERT INTO ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?)";

			Address addr = address.Address();

			ps = conn.prepareStatement(addressInsert);
			ps.setString(1, addr.getStreet());
			ps.setString(2, addr.getCity());
			ps.setString(3, addr.getState());
			ps.setString(4, addr.getZipCode());
			ps.executeUpdate();
			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
				int i = rs.getInt(1);
				ps = conn.prepareStatement(customerInsert);
				ps.setString(1, customer.getFirstName());
				ps.setString(2, customer.getLastName());
				ps.setString(3, address.getEmail1());
				ps.setInt(4, i);
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

	public static List<Customer> getAllCustomers() {
		Connection conn = null, connDS = null;
		PreparedStatement ps = null;
		Statement stmt = null;
	}
}