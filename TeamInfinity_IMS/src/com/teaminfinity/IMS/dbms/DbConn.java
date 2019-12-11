package com.teaminfinity.IMS.dbms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static Connection connection = null;
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/infinitysystem");
			connection = ds.getConnection();
			
		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
