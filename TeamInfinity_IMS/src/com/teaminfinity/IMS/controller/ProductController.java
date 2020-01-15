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

import com.teaminfinity.IMS.dbms.ProductCRUD;
import com.teaminfinity.IMS.model.Product;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCRUD crud = new ProductCRUD();
		
		// declarations
		response.setContentType("text/html");
		HttpSession session = null;
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		if(request.getParameter("action")=="add") {
			Product prod = new Product();
			
			prod.setProductId(Integer.parseInt(request.getParameter("category")));
			prod.setProductName(request.getParameter("product-name"));
			prod.setAmount(Integer.parseInt(request.getParameter("stock-amount")));
			prod.setReorderAmount(Integer.parseInt(request.getParameter("reorder-amount")));
			prod.setLocation(request.getParameter("location"));
			prod.setPrice(Integer.parseInt(request.getParameter("price")));
			prod.setDescription(request.getParameter("description"));
			//prod.setCategoryId(Integer.parseInt(request.getParameter("")));
			prod.setCategoryId(0);
			
			try {
				crud.insertIntoProduct(prod);
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			} catch (SQLException se) {
				se.printStackTrace();
			}		
			//session.setAttribute("name", );
		}		
	}// end doPost

}
