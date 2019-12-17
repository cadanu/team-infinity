package com.teaminfinity.IMS.dbms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.eclipse.jdt.internal.compiler.apt.model.Factory;

import com.teaminfinity.IMS.model.Authorized;
import com.teaminfinity.IMS.model.Business;
import com.teaminfinity.IMS.model.Persons;

public class UserCRUD implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	static Connection connection = null;
//	
//	static {
//		try {
//			
//			Context context = new InitialContext();
//			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/infinitysystem");
//			connection = ds.getConnection();
//			//Factory.class.cast(ds).
//			
//			
//			} catch(SQLException se) {
//				se.getMessage();
//			} catch(NamingException ne) {
//				ne.getMessage();
//			}				
//		}
//	
//	public static Connection getConnection() {
//		System.out.println("dbconn second out: " + connection.toString());
//		return connection;
//	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// CREATE
	
	
	
	// insert into Persons
	public void insertIntoPersons(Persons persons) //////////////////////////////////////////////// insert into persons
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		
		try {
//			if(conn == null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			String sql = "insert into Persons(first_name, last_name, email, users)" + 
						"values(?,?,?,?);";
			
			ps = conn.prepareStatement(sql); // prepared			
			ps.setString(1, persons.getFirstName());
			ps.setString(2, persons.getLastName());
			ps.setString(3, persons.getEmail());
			ps.setBoolean(4, persons.isUsers());			
			ps.execute();
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} finally { 
			ps.close();
			conn.close(); 
		}
		System.out.println("Reached the end: Create");
	}
	
	// insert into Authorized
		public void insertIntoAuthorized(Authorized auth) /////////////////////// insert into Authorized
				throws SQLException, ClassNotFoundException {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
				
			} catch(ClassNotFoundException cnfe) {
				cnfe.getMessage();
			} catch(SQLException se) {
				se.getMessage();
			}
			
			PreparedStatement ps = null;
			
			try {
//				if(conn == null || conn.isClosed()) {
//					conn = DbConn.getConnection();
//				}
				
				String sql = "insert into Authorized(pass, entity_id) values(?,?);";
				
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, auth.getPassword());
				ps.setInt(2, auth.getEntityId());
				ps.execute();
				
			} catch(SQLException se) {
				se.printStackTrace();
			} catch(NullPointerException npe) {
				npe.printStackTrace();
			} finally {
				ps.close();
				conn.close();
			}
			System.out.println("Reached the end: Create");
		}
	
	// insert into Business
		public void insertIntoBusiness(Business business) /////////////////////// insert into Business
				throws SQLException, ClassNotFoundException {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
				
			} catch(ClassNotFoundException cnfe) {
				cnfe.getMessage();
			} catch(SQLException se) {
				se.getMessage();
			}
			
			PreparedStatement ps = null;
			
			try {
//				if(conn == null || conn.isClosed()) {
//					conn = DbConn.getConnection();
//				}
				
				String sql = "insert into Business(business_name, street_add, street_add2, city, province, postal, country, entity_id)" + 
							" values(?,?,?,?,?,?,?,?);";
				
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, business.getBusinessName());
				ps.setString(2, business.getStreetAdd());
				ps.setString(3, business.getStreetAdd2());
				ps.setString(4, business.getCity());
				ps.setString(5, business.getProvince());
				ps.setString(6, business.getPostal());
				ps.setString(7, business.getCountry());
				ps.setInt(8, business.getEntityId());
				ps.execute();
				
			} catch(SQLException se) {
				se.printStackTrace();
			} catch(NullPointerException npe) {
				npe.printStackTrace();
			} finally {
				ps.close();
				conn.close();
			}
			System.out.println("Reached the end: Create");
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// READ
	
	// login
	public boolean getLogin(String user, String pass) //////////////////////////////////////////////// insert into login
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean valid = false;
		
		try {
//			if(conn == null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			String sql = "select p.email, a.pass " + 
						"from Persons p " + 
						"inner join Authorized a " + 
						"on p.person_id=a.entity_id " + 
						"where p.email=? and a.pass=?;";
			
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
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		System.out.println("Reached the end: Login");
		return valid;		
	}
	
	public Persons readPerson(String email) {////////////////////////////////////////////////////////////////// read persons
		Persons persons = new Persons();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
//			if(conn==null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			sql = "select * from Persons where email=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			//
			if(rs.next()) {
				persons.setPersonId(rs.getInt("person_id"));
				persons.setFirstName(rs.getString("first_name"));
				persons.setLastName(rs.getString("last_name"));
				persons.setEmail(rs.getString("email"));
				persons.setUsers(rs.getBoolean("users"));
			}
			
			System.out.println(persons.getPersonId() + persons.getEmail() + persons.getFirstName());
			
		} catch(SQLException se) {
			se.getMessage();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return persons;
	}
	
	public Business readBusiness(int id) {////////////////////////////////////////////////////////////////// read persons
		Business business = new Business();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
//			if(conn==null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			sql = "select * from Business where entity_id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				business.setBusinessName(rs.getString("business_name"));
				business.setStreetAdd(rs.getString("street_add"));
				business.setStreetAdd2(rs.getString("street_add2"));
				business.setCity(rs.getString("city"));
				business.setProvince(rs.getString("province"));
				business.setPostal(rs.getString("postal"));
				business.setCountry(rs.getString("country"));
				business.setEntityId(id);
			}
			
		} catch(SQLException se) {
			se.getMessage();
		} finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		return business;
	}
	
	public int getSingleInt(Persons persons) ///////////////////////////////////////////////////////// get single int
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
//		if(conn == null || conn.isClosed()) {
//			conn = DbConn.getConnection();
//		}
		
		try {			
			String sql = "SELECT person_id FROM Persons WHERE email=?;"; //
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, persons.getEmail());
			rs = ps.executeQuery();
			
			//System.out.println(rs.getInt(1));
			
			result = rs.getInt("person_id");
		
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}		
		System.out.println("Reached the end: getSingleInt");
		return result;
	}
	
	public static String getBusinessName(String param) //////////////////////////////////////////// get Business name
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";

//		if(conn == null || conn.isClosed()) {
//			conn = DbConn.getConnection();
//		}
		
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
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
		System.out.println("Reached the end: getBusinessName");
		return result;
	}
	
	public static String getUserName(String param) ////////////////////////////////////////////////// get user name
			throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		
//		if(conn == null || conn.isClosed()) {
//			conn = DbConn.getConnection();
//		}
		
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
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
		System.out.println("Reached the end: getUserName");
		return result;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// UPDATE
	
	public void updateUserPerson() {////////////////////////////////////////////////////////////////// read persons
		Persons persons = new Persons();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
//			if(conn==null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			sql = "select * from Business where entity_id=?";
			
			ps = conn.prepareStatement(sql);
			
			
		} catch(SQLException se) {
			se.getMessage();
		} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	public void updateUserBusiness() {////////////////////////////////////////////////////////////////// read persons
		Business business = new Business();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch(SQLException se) {
			se.getMessage();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
//			if(conn==null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//			}
			
			sql = "select * from Business where entity_id=?";
			
			ps = conn.prepareStatement(sql);
			
			
		} catch(SQLException se) {
			se.getMessage();
		} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
