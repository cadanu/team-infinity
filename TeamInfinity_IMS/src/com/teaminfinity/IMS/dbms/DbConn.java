package com.teaminfinity.IMS.dbms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DbConn implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	static Connection connection = null;
	
//	static {
//		try {
//			
//			Context context = new InitialContext();
//			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/infinitysystem");
//			connection = ds.getConnection();			
//			
//			} catch(SQLException se) {
//				se.getMessage();
//			} catch(NamingException ne) {
//				ne.getMessage();
//			}				
//		}
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
//			
//		} catch(ClassNotFoundException cnfe) {
//			cnfe.getMessage();
//		} catch(SQLException se) {
//			se.getMessage();
//		}
//	}
//	
//	public static Connection getConnection() {
//		System.out.println("dbconn second out: " + connection.toString());
//		return connection;
//	}
}
