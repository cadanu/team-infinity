package com.teaminfinity.IMS.dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.teaminfinity.IMS.model.User;

public class UserCRUD {
	
	// create user
	public void create(User user) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "INSERT INTO User(first_name, last_name, email, business_name, street_add, " +
					"street_add2, city, province, postal, country) VALUES (?,?,?,?,?,?,?,?,?,?);";
			
			ps = conn.prepareStatement(sql); // prepared			
			ps.setString(1, user.getfName());
			ps.setString(2, user.getlName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getbName());
			ps.setString(5, user.getStreetAdd());
			ps.setString(6, user.getStreetAdd2());
			ps.setString(7, user.getCity());
			ps.setString(8, user.getProvince());
			ps.setString(9, user.getPostal());
			ps.setString(10, user.getCountry());
			
			ps.executeUpdate();
			
		} catch(SQLException se) {
			se.printStackTrace();
		}		
	}
	
	// login
	public boolean getLogin(String user, String pass) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean valid = false;
		
		try {
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "SELECT email, password FROM User WHERE (email=? AND password=?);";
			
			ps = conn.prepareStatement(sql); // prepared		
			ps.setString(1, user);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			while(!rs.isAfterLast()) {
				valid = rs.next();
			}
			
			
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return valid;
		
	}
	
	public String singleQuery(String col, String param) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		
		try {
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "SELECT ? FROM User WHERE email=?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, col);
			ps.setString(2, param);
			
			rs = ps.executeQuery();
			
			result = rs.getString(1);
		
		} catch(SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
