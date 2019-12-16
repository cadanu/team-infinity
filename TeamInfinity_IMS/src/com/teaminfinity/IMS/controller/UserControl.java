package com.teaminfinity.IMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teaminfinity.IMS.dbms.DbConn;
import com.teaminfinity.IMS.dbms.UserCRUD;
import com.teaminfinity.IMS.model.Authorized;
import com.teaminfinity.IMS.model.Business;
import com.teaminfinity.IMS.model.Persons;
import com.teaminfinity.IMS.model.User;


public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UserCRUD crud = new UserCRUD();
		
		// declarations
		response.setContentType("text/html");
		HttpSession session = null;
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;		
		
		//System.out.println("it begins"); 
		
		// process login
		if(request.getParameter("action").equals("login")) { // LOGIN
			
			String url = "/error.jsp";
			String message = "";
			
			// user info
			String user = "";// refers to email
			String pass = "";
			String name = "";
			//String query = "";
			
			// validate form if parameters !empty
			boolean entry = true;
			boolean validate = false;
			
			if(request.getParameter("usr") != null && !request.getParameter("usr").isEmpty())
				user = request.getParameter("usr");
			else entry = false;
			if(request.getParameter("pss") != null && !request.getParameter("pss").isEmpty())
				pass = request.getParameter("pss");
			else entry = false;
			
			System.out.println("1: user, pass" + user + ", " + pass + ".");		
			
			if(entry) {
				try {
					validate = crud.getLogin(user, pass);// evaluates login param against database values
				
				} catch(ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				} catch(SQLException se) {
					se.printStackTrace();
				}
				
				if(validate) {
					try {
						name = UserCRUD.getBusinessName(user);// get business name
						System.out.println("Inside Validate if 1: user, name: " + user + ", " + name);							
							
						if(name == null || name.length() == 0 || name == "")// if business name null - get User name
							name = UserCRUD.getUserName(user);
							
						System.out.println("Inside Validate if 2: user, name: " + user + ", " + name);						
							
					} catch(ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
					} catch(SQLException se) {
						se.printStackTrace();
					}
					
					session = request.getSession(false);
					if(session != null && !session.isNew()) {
						session.setAttribute("email", user);
						if(name!=null) {
							session.setAttribute("name", name);
						}
					}
					
					System.out.println("End validate if: email, name: " + user + ", " + name);
				}
				
				System.out.println("Outside below validate if: email, name: " + user + ", " + name);
			}
			//top: 100px, right: 10px; 
			
			if(validate) {
				url = "/account.jsp";
				message = "<b style=\"position: absolute; color:red;\">Login Successful</b>";
			}
			else {
				url = "/login.jsp";
				message = "<b style=\"position: absolute; color:red;\">Login Unsuccessful</b>";
			}
			
			System.out.println("2: user, pass, validate" + user + ", " + pass + ", " + validate + ".");
			
			out.print(message);
			rd = request.getRequestDispatcher(url);
			rd.include(request, response);			
			
			System.out.println("End Login");
				
		}// end process login
		
		
		// process sign ups
		if(request.getParameter("action").equals("signup")) { // SIGN-UP
			System.out.println("we're in signup");
			// model objects
			Persons persons = new Persons();
			Business business = new Business();
			Authorized auth = new Authorized();
			
			String url = "/error.jsp";
			String message = "";
			
			// validate form parameters !empty
			boolean entry = true;
			
			// Persons
			if(request.getParameter("first-name") != null && !request.getParameter("first-name").isEmpty())
				persons.setFirstName(request.getParameter("first-name"));
			else entry = false;
			if(request.getParameter("last-name") != null && !request.getParameter("last-name").isEmpty())
				persons.setLastName(request.getParameter("last-name"));
			else entry = false;
			if(request.getParameter("email") != null && !request.getParameter("email").isEmpty())
				persons.setEmail(request.getParameter("email"));
			else entry = false;
			// boolean users will be set before (c)rud
			
			
			// Business
			if(request.getParameter("business-name") != null && !request.getParameter("business-name").isEmpty())
				business.setBusinessName(request.getParameter("business-name"));
			if(request.getParameter("street-add") != null && !request.getParameter("street-add").isEmpty())
				business.setStreetAdd(request.getParameter("street-add"));
			else entry = false;
			if(request.getParameter("street-add2") != null && !request.getParameter("street-add2").isEmpty())
				business.setStreetAdd2(request.getParameter("street-add2"));
			if(request.getParameter("city") != null && !request.getParameter("city").isEmpty())
				business.setCity(request.getParameter("city"));
			else entry = false;
			if(request.getParameter("province") != null && !request.getParameter("province").isEmpty())
				business.setProvince(request.getParameter("province"));
			else entry = false;
			if(request.getParameter("postal") != null && !request.getParameter("postal").isEmpty())
				business.setPostal(request.getParameter("postal"));
			else entry = false;
			if(request.getParameter("country") != null && !request.getParameter("country").isEmpty())
				business.setCountry(request.getParameter("country"));
			else entry = false;
			// entity id will be set after person_id auto_increments
			
			
			System.out.println("we're in signup: entry: " + entry);
			
			// create User object
			if(entry) {
				persons.setUsers(true);
				try {
					crud.insertIntoPersons(persons);
					persons.setPersonId(crud.getSingleInt("person_id", "Persons", "email", persons.getEmail()));
					crud.insertIntoAuthorized(auth, persons);					
					crud.insertIntoBusiness(business, persons);
					
					url="/welcome.jsp";
					message = "<b style=\"position: absolute; color:red;\">Signup Successful</b>";
					
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				}							
			} else {
				url="/signup.jsp";
				message = "<b style=\"position: absolute; color:red;\">Signup Unsuccessful</b>";
			}
			
			out.print(message);
			rd = request.getRequestDispatcher(url);
			rd.include(request, response);
			
			System.out.println("End Signup");	
			
		}// end signup code		
		
	}// end doPost method

}// end UserControl class
