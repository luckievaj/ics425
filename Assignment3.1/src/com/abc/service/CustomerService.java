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
import com.abc.model.Person;

public class CustomerService {

	public static void persistCustomer(Person person) {
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
					"INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME) VALUES (?, ?)";
//			String addressInsert = 
//					"INSERT INTO ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?)";
//
//			Address addr = person.getAddress();
//
//			ps = conn.prepareStatement(addressInsert);
//			ps.setString(1, addr.getStreet());
//			ps.setString(2, addr.getCity());
//			ps.setString(3, addr.getState());
//			ps.setString(4, addr.getZip());
//			ps.executeUpdate();
			//			if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
				int i = rs.getInt(1);
				ps = conn.prepareStatement(customerInsert);
				ps.setString(1, person.getFirstName());
				ps.setString(2, person.getLastName());
//				ps.setString(3, person.getEmailAddress());
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
			String selectAll = "SELECT * FROM CUSTOMER C INNER JOIN ADDRESS A ON C.ADDRESS_ID = A.ID";
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(selectAll);
			while (rs.next()) {
				Address addr  = new Address();
				Customer cust = new Customer();
				cust.setFirstName(rs.getString("FIRST_NAME"));
				cust.setLastName(rs.getString("LAST_NAME"));
				cust.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				addr.setStreet(rs.getString("STREET"));
				addr.setCity(rs.getString("CITY"));
				addr.setState(rs.getString("STATE"));
				addr.setZip(rs.getString("ZIPCODE"));
				cust.setAddress(addr);
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
}
