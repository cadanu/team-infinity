package com.teaminfinity.IMS.dbms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teaminfinity.IMS.model.Authorized;
import com.teaminfinity.IMS.model.Business;
import com.teaminfinity.IMS.model.Persons;

public class UserCRUD implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// insert into Persons
	public void insertIntoPersons(Persons persons) 
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement ps = null;
		
		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		String sql = "insert into Persons(first_name, last_name, email, users)" + 
					"values(?,?,?,?);";
		
		try {			
			ps = conn.prepareStatement(sql); // prepared			
			ps.setString(1, persons.getFirstName());
			ps.setString(2, persons.getLastName());
			ps.setString(3, persons.getEmail());
			ps.setBoolean(4, persons.isUsers());			
			ps.executeUpdate();
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} finally { conn.close(); }
		System.out.println("Reached the end: Create");
	}
	
	// insert into Authorized
		public void insertIntoAuthorized(Authorized auth, Persons persons) 
				throws SQLException, ClassNotFoundException {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement ps = null;
			
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "insert into Authorized(pass, entity_id) values(?,?);";
			
			try {			
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, auth.getPassword());
				ps.setInt(2, persons.getPersonId());
				ps.executeUpdate();
				
			} catch(SQLException se) {
				se.printStackTrace();
			} catch(NullPointerException npe) {
				npe.printStackTrace();
			} finally { conn.close(); }
			System.out.println("Reached the end: Create");
		}
	
	// insert into Business
		public void insertIntoBusiness(Business business, Persons persons) 
				throws SQLException, ClassNotFoundException {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement ps = null;
			
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "insert into Business(business_name, street_add, street_add2, city, province, postal, country, entity_id)" + 
						" values(?,?,?,?,?,?,?,?);";
			
			try {			
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, business.getBusinessName());
				ps.setString(2, business.getStreetAdd());
				ps.setString(3, business.getStreetAdd2());
				ps.setString(4, business.getCity());
				ps.setString(5, business.getProvince());
				ps.setString(6, business.getPostal());
				ps.setString(7, business.getCountry());
				ps.setInt(8, persons.getPersonId());
				ps.executeUpdate();
				
			} catch(SQLException se) {
				se.printStackTrace();
			} catch(NullPointerException npe) {
				npe.printStackTrace();
			} finally { conn.close(); }
			System.out.println("Reached the end: Create");
		}
	
	// login
	public boolean getLogin(String user, String pass) 
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean valid = false;
		
		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		String sql = "select p.email, a.pass " + 
					"from Persons p " + 
					"inner join Authorized a " + 
					"on p.person_id=a.entity_id " + 
					"where p.email=? and a.pass=?;";
		
		try {			
			
			ps = conn.prepareStatement(sql);	
			ps.setString(1, user);
			ps.setString(2, pass);
			//System.out.println(ps.executeQuery());
			rs = ps.executeQuery();
			valid = rs.next();
			System.out.println(user + pass);
			System.out.println();
			System.out.println("conn: " + conn);
			System.out.println("In getLogin: valid, connection: " + valid + conn);
			
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} finally { conn.close(); }
		System.out.println("Reached the end: Login");
		return valid;
		
	}
	
	public int getSingleInt(String column, String table, String row, String param) 
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		try {			
			String sql = "SELECT ? FROM ? WHERE ?=?;"; // select person_id from Persons where email=email
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, column);
			ps.setString(2, table);
			ps.setString(3, row);
			ps.setString(4, param);
			rs = ps.executeQuery();
			
			result = rs.getInt(1);
		
		} catch(SQLException se) {
			se.printStackTrace();System.out.println("Exception: gun: se");
		} catch(NullPointerException npe) {
			npe.printStackTrace();System.out.println("Exception: gun: npe");
		} finally { conn.close(); }		
		
		System.out.println("Reached the end: getUserName");
		return result;
	}
	
	public static String getBusinessName(String param) 
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";

		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		String sql = "SELECT business_name FROM Business WHERE email=?;";
		
		try {			
			ps = conn.prepareStatement(sql);
			//ps.setString(1, col);
			//ps.setString(2, table);
			ps.setString(1, param);
			
			rs = ps.executeQuery();
			
			result = rs.getString(1);
		
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} finally { conn.close(); }		
		
		System.out.println("Reached the end: getBusinessName");
		return result;
	}
	
	public static String getUserName(String param) 
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		
		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		try {			
			
			String sql = "SELECT first_name, last_name FROM Users WHERE email=?;";
			
			ps = conn.prepareStatement(sql);
			//ps.setString(1, col);
			//ps.setString(2, table);
			ps.setString(1, param);
			
			rs = ps.executeQuery();
			
			result = rs.getString(1) + " " + rs.getString(2);
		
		} catch(SQLException se) {
			se.printStackTrace();System.out.println("Exception: gun: se");
		} catch(NullPointerException npe) {
			npe.printStackTrace();System.out.println("Exception: gun: npe");
		} finally { conn.close(); }		
		
		System.out.println("Reached the end: getUserName");
		return result;
	}	
}
