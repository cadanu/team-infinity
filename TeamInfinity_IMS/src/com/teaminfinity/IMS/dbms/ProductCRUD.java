package com.teaminfinity.IMS.dbms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teaminfinity.IMS.model.Category;
import com.teaminfinity.IMS.model.Product;
import com.teaminfinity.IMS.model.PurchaseOrder;

public class ProductCRUD implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// insert into Category
		public void insertIntoCategory(Category category) //////////////////////////////////////////////// insert into category
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
				
				String sql = "insert into Category(category_name) values(?);";
				
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, category.getCategory());			
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
		
		
		// insert into Product
		public void insertIntoProduct(Product product) //////////////////////////////////////////////// insert into product
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
				
				String sql = "insert into Product(product_name, amount, reorder_amount, location, price, category_id)" + 
							"values(?,?,?,?,?,?);";
				
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getAmount());
				ps.setInt(3, product.getReorderAmount());
				ps.setString(4, product.getLocation());
				ps.setInt(5, product.getPrice());
				ps.setInt(6, product.getCategoryId());
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
		
		// insert into Persons
		public void insertIntoPO(PurchaseOrder po) //////////////////////////////////////////////// insert into persons
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
				
				String sql = "insert into PO(po_date, user_id, product_id, customer_id) values(?,?,?,?);";
				
				ps = conn.prepareStatement(sql); // prepared			
				ps.setString(1, po.getDate());
				ps.setInt(2, po.getUserId());
				ps.setInt(3, po.getProductId());
				ps.setInt(4, po.getCustomerId());			
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


		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// READ
		
		public ArrayList<Product> readProduct() {////////////////////////////////////////////////////////////////// read persons
			Product product = new Product();
			
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
			ArrayList<Product> list = null;
			
			try {
//				if(conn==null || conn.isClosed()) {
//					conn = DbConn.getConnection();
//				}
				
				sql = "select * from Product";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				list = new ArrayList<Product>();
				while(rs.next()) {
					product.setProductId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setAmount(rs.getInt("amount"));
					product.setReorderAmount(rs.getInt("reorder_amount"));
					product.setLocation(rs.getString("location"));
					product.setPrice(rs.getInt("price"));
					product.setCategoryId(rs.getInt("category_id"));
					list.add(product);
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
			return list;
		}
		
		
//		public PurchaseOrder po (int id) {////////////////////////////////////////////////////////////////// read PurchaseOrder
//			PurchaseOrder po = new PurchaseOrder();// for printing and automated inventory management
//			
//			Connection conn = null;
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
//				
//			} catch(ClassNotFoundException cnfe) {
//				cnfe.getMessage();
//			} catch(SQLException se) {
//				se.getMessage();
//			}
//			
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			String sql = "";
//			
//			try {
////				if(conn==null || conn.isClosed()) {
////					conn = DbConn.getConnection();
////				}
//				
//				sql = "select * from PO where po_id=?";
//				
//				ps = conn.prepareStatement(sql);
//				rs = ps.executeQuery();
//				
//				if(rs.next()) {
//					
//				}
//				
//				
//			} catch(SQLException se) {
//				se.getMessage();
//			} finally {
//				try {
//					rs.close();
//					ps.close();
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}	
//			return persons;
//		}
//		
//		
//		public Persons readPerson(String email) {////////////////////////////////////////////////////////////////// read persons
//			Persons persons = new Persons();
//			
//			Connection conn = null;
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitysystem", "root", "1234");
//				
//			} catch(ClassNotFoundException cnfe) {
//				cnfe.getMessage();
//			} catch(SQLException se) {
//				se.getMessage();
//			}
//			
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			String sql = "";
//			
//			try {
////				if(conn==null || conn.isClosed()) {
////					conn = DbConn.getConnection();
////				}
//				
//				sql = "select * from Persons where email=?";
//				
//				ps = conn.prepareStatement(sql);
//				ps.setString(1, email);
//				rs = ps.executeQuery();
//				//
//				if(rs.next()) {
//					persons.setPersonId(rs.getInt("person_id"));
//					persons.setFirstName(rs.getString("first_name"));
//					persons.setLastName(rs.getString("last_name"));
//					persons.setEmail(rs.getString("email"));
//					persons.setUsers(rs.getBoolean("users"));
//				}
//				
//				System.out.println(persons.getPersonId() + persons.getEmail() + persons.getFirstName());
//				
//			} catch(SQLException se) {
//				se.getMessage();
//			} finally {
//				try {
//					rs.close();
//					ps.close();
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}	
//			return persons;
//		}

		
		

}
