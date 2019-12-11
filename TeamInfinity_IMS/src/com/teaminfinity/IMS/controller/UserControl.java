package com.teaminfinity.IMS.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teaminfinity.IMS.dbms.UserCRUD;
import com.teaminfinity.IMS.model.User;


public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// declarations
		UserCRUD crud = new UserCRUD();
		
		// process logins
		if(request.getParameter("action").contentEquals("login")) {

			String url = "";
			String message = "";
			
			// user info
			String user = "";
			String pass = "";
			String name = "";
			
			// validate form parameters !empty
			boolean entry = true;
			boolean validate = false;
			
			if(request.getParameter("usr") != null && !request.getParameter("usr").isEmpty())
				user = request.getParameter("usr");
			else entry = false;
			if(request.getParameter("pss") != null && !request.getParameter("pss").isEmpty())
				pass = request.getParameter("pss");
			else entry = false;
			
			if(entry) {
				try {
					validate = crud.getLogin(user, pass);
				
				} catch(ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				} catch(SQLException se) {
					se.printStackTrace();
				}
				
				if(validate) {
					try {
						if(crud.singleQuery("business_name", user) != null && !crud.singleQuery("business_name", user).isEmpty()) {
							name = crud.singleQuery("business_name", user);
							
						} else if(crud.singleQuery("first_name", user) != null && !crud.singleQuery("first_name", user).isEmpty()) {
							name = crud.singleQuery("first_name", user).concat(" " + crud.singleQuery("last_name", user));
						
						} else
							throw new IllegalArgumentException();

							
					} catch(ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
					} catch(SQLException se) {
						se.printStackTrace();
					} catch(IllegalArgumentException iae) {
						iae.getMessage().concat(". User should have a name!");
					} finally { name = "USER"; }
						
					request.getSession().setAttribute("user",  user);
					request.getSession().setAttribute("user",  name);
				}
			}
		}
		
		// process sign ups
		if(request.getParameter("action").contentEquals("signup")) {
			
			String url = "";
			String message = "";
			
			// contact user
			String fName = "";
			String lName  = "";
			String email = "";
			// business info
			String bName = "";
			String streetAdd = "";
			String streetAdd2 = "";
			String city = "";
			String province = "";
			String postal = "";
			String country = "";
			
			// validate form parameters !empty
			boolean entry = true;
			
			if(request.getParameter("first-name") != null && !request.getParameter("first-name").isEmpty())
				fName = request.getParameter("first-name");
			else entry = false;
			if(request.getParameter("last-name") != null && !request.getParameter("last-name").isEmpty())
				lName = request.getParameter("last-name");
			else entry = false;
			if(request.getParameter("email") != null && !request.getParameter("email").isEmpty())
				email = request.getParameter("email");
			else entry = false;
			if(request.getParameter("business-name") != null && !request.getParameter("business-name").isEmpty())
				bName = request.getParameter("business-name");
			else bName = "n/a";
			if(request.getParameter("street-add") != null && !request.getParameter("street-add").isEmpty())
				streetAdd = request.getParameter("street-add");
			else entry = false;
			if(request.getParameter("street-add2") != null && !request.getParameter("street-add2").isEmpty())
				streetAdd2 = request.getParameter("street-add2");
			else entry = false;
			if(request.getParameter("city") != null && !request.getParameter("city").isEmpty())
				city = request.getParameter("city");
			else entry = false;
			if(request.getParameter("province") != null && !request.getParameter("province").isEmpty())
				province = request.getParameter("province");
			else entry = false;
			if(request.getParameter("postal") != null && !request.getParameter("postal").isEmpty())
				postal = request.getParameter("postal");
			else entry = false;
			if(request.getParameter("country") != null && !request.getParameter("country").isEmpty())
				country = request.getParameter("country");
			else entry = false;
			
			// create User object
			if(entry) { 
				User user = new User(fName,lName,email,bName,streetAdd,streetAdd2,city,province,postal,country);
				
				try {
					crud.create(user);
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				}
				
			}// end if
		}// end signup code		
		
	}// end doPost method

}// end UserControl class
