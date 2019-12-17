package com.teaminfinity.IMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teaminfinity.IMS.dbms.UserCRUD;
import com.teaminfinity.IMS.model.Authorized;
import com.teaminfinity.IMS.model.Business;
import com.teaminfinity.IMS.model.Persons;


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
			
			Persons persons = new Persons();
			Business business = new Business();
			
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
					persons = crud.readPerson(user);
					business = crud.readBusiness(persons.getPersonId());
							
					System.out.println("Inside Validate if 2: user, name: " + user + ", " + name);						
					
					session = request.getSession(false);
					if(session != null && !session.isNew()) {
						
						session.setAttribute("personId", persons.getPersonId());
						session.setAttribute("firstName", persons.getFirstName());
						session.setAttribute("lastName", persons.getLastName());
						session.setAttribute("email", persons.getEmail());
						
						session.setAttribute("businessName", business.getBusinessName());
						session.setAttribute("streetAdd", business.getStreetAdd());
						session.setAttribute("streetAdd2", business.getStreetAdd2());
						session.setAttribute("city", business.getCity());
						session.setAttribute("province", business.getProvince());
						session.setAttribute("postal", business.getPostal());
						session.setAttribute("country", business.getCountry());
						session.setAttribute("entityId", business.getEntityId());
						
					}
					
					System.out.println("Persons: " + persons.getFirstName() + persons.getPersonId());
				}					
				System.out.println("End validate if: email, name: " + user + ", " + name);// debug
			}				
			System.out.println("Outside below validate if: email, name: " + user + ", " + name);// debug
				
			// evaluate message
			if(validate) {
				url = "/account.jsp";
				message = "<b style=\"position: absolute; color:red;\">Login Successful</b>";
			}
			else {
				url = "/login.jsp";
				message = "<b style=\"position: absolute; color:red;\">Login Unsuccessful</b>";
			}			
			System.out.println("2: user, pass, validate" + user + ", " + pass + ", " + validate + ".");// debug
			
			out.print(message);
			rd = request.getRequestDispatcher(url);
			rd.include(request, response);			
			
			System.out.println("End Login");// debug				
		}// end process login
		
		
		
		
		
		
		// process sign ups
		if(request.getParameter("action").equals("signup")) { // SIGN-UP
			System.out.println("we're in signup");
			//Thread one = null; Thread two = null; Thread three = null; Thread four = null;
			
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
			System.out.println("finished persons");
			
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
			System.out.println("finished business");
			
			// Authorized
			if(request.getParameter("password") != null && !request.getParameter("password").isEmpty())
				auth.setPassword(request.getParameter("password"));
			System.out.print("password");
			
			
			System.out.println("we're in signup: entry: " + entry);
			

			// create Authorized User(Person,Authorize,Business) object
			if(entry) {
				persons.setUsers(true);// set users to true (Auth user)
				try {
					crud.insertIntoPersons(persons);// insert into persons table
					System.out.println("finished InsertIntoPersons");
					
					// match id's (pk's to fk's after auto_increment
					persons.setPersonId( crud.readPerson(persons.getEmail()).getPersonId() );// set person_id
					System.out.println("finished getSingleInt:PersonID");
					
					business.setEntityId(persons.getPersonId());// set entity_id to person_id
					auth.setEntityId(persons.getPersonId());// set entity_id to person_id
					System.out.println("finished setID:Business, Auth");					
					
					crud.insertIntoAuthorized(auth);// insert into auth table
					System.out.println("finished insertIntoAuth");
					
					crud.insertIntoBusiness(business);// insert into business table
					System.out.println("finshed insertIntoBusiness");
					
					
				} catch(SQLException se) {
					se.getMessage();
				} catch(ClassNotFoundException cnfe) {
					cnfe.getMessage();
				}
				
				//session.setAttribute("email", persons.getEmail());
					
				url="/login.jsp";
				message = "<b style=\"position: absolute; color:red;\">Signup Successful</b>";				
				
			} else {
				url="/signup.jsp";
				message = "<b style=\"position: absolute; color:red;\">Unsuccessful Attempt at Signing Up</b>";
			}
			
			System.out.println("Persons person_id: " + persons.getPersonId());
			System.out.println("Business entity_id: " + business.getEntityId());
			System.out.println("Auth entity_id: " + auth.getEntityId());
			
			out.print(message);
			rd = request.getRequestDispatcher(url);
			rd.include(request, response);
			
			System.out.println("End Signup");
					
//					one = new Thread(new Runnable() {
//						public void run() {
//							try {
//								crud.insertIntoPersons(persons);///
//							} catch(SQLException se) {
//								se.getMessage();
//							} catch(ClassNotFoundException cnfe) {
//								cnfe.getMessage();
//							}
//						}
//					});
//					one.setPriority(5);
//					two = new Thread(new Runnable() {
//						public void run() {
//							try {
//								persons.setPersonId(crud.getSingleInt("person_id", "Persons", "email", persons.getEmail()));
//							} catch(SQLException se) {
//								se.getMessage();
//							} catch(ClassNotFoundException cnfe) {
//								cnfe.getMessage();
//							}
//						}
//					});
//					two.setPriority(4);
//					three = new Thread(new Runnable() {
//						public void run() {
//							try {
//								crud.insertIntoAuthorized(auth, persons);	
//							} catch(SQLException se) {
//								se.getMessage();
//							} catch(ClassNotFoundException cnfe) {
//								cnfe.getMessage();
//							}
//						}
//					});
//					three.setPriority(3);
//					four = new Thread(new Runnable() {
//						public void run() {
//							try {
//								crud.insertIntoBusiness(business, persons);
//							} catch(SQLException se) {
//								se.getMessage();
//							} catch(ClassNotFoundException cnfe) {
//								cnfe.getMessage();
//							}
//						}
//					});
//					four.setPriority(2);					
//					one.start();two.start();three.start();four.start();					
					
					
				
					
//				} catch (SecurityException se) {
//					se.printStackTrace();
//				} catch (IllegalArgumentException iae) {
//					iae.printStackTrace();
//					
			
		}// end signup code		
		
	}// end doPost method

}// end UserControl class
