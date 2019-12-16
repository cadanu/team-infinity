package com.teaminfinity.IMS.dbms;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConn {
	
	static Connection connection = null;
	
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/infinitysystem");
			connection = ds.getConnection();
			//System.out.println("dbconn first out: " + connection.toString());
			//System.out.println("metadata" + connection.getMetaData());
			//connection.setAutoCommit(true);
		}
		catch(NamingException ne) {
			ne.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		//System.out.println("dbconn second out: " + connection.toString());
		return connection;
	}
}
