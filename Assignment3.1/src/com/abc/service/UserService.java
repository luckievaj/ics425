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

import com.abc.model.User;

public class UserService {

	public static void persistUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String userInsert = 
					"INSERT INTO USER (FIRST_NAME, LAST_NAME, USER_NAME) VALUES (?, ?, ?)";

			ps = conn.prepareStatement(userInsert);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.executeUpdate();
			//	if (true) throw new Exception();
			stmt = conn.createStatement();
			rs  = stmt.executeQuery("SELECT LAST_INSERT_ID()");
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

	public static List<User> getAllUsers() {
		Connection conn = null, connDS = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ics425");
			conn = ds.getConnection();				
			String selectAll = "SELECT * FROM USER";
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(selectAll);
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setUserName(rs.getString("USER_NAME"));				
				userList.add(user);
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
		return userList;		
	}
}
