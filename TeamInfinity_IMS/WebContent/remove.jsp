<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/design.css"/>
	<title>IMS: Product Summary and Update</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div style="color:red;"><h3>IMS: Product Removal</h3></div>
	
	<span><a href="#" rel="#">&#60; Previous Product &#60;</a></span>|<span><a href="#" rel="#">> Next Product ></a></span>
	
	<div style="position:absolute;margin:60px 0 0 20px;border-right:3px solid silver;color:blue;max-width:150px;padding:10px">
		<span ><a href="add.jsp" rel="Add Records">Add Product</a></span><br><br>
		<span ><a href="products.jsp" rel="Remove Records">Update Product</a></span>
	</div>
	
	<div id="summary-box" style="position:absolute;right:38%;">
	
	<fieldset>
	<legend><b>Product Removal</b></legend>
	
	<form action="#" method="post">
		<table>
				<tr><td>Product to Remove:</td></tr>				
			<tr><td>${productName}</td></tr>
			
				<tr><td>Amount in Stock:</td></tr>
			<tr><td>${amount}</td>
	
				<tr><td>Location in Storage:</td></tr>
			<tr><td>${location}</tr>
			
		</table>
		<section style="border: 1px solid silver;color:red;padding:5px;">
			<b>Remaining Inventory: </b><br>
			Destroy remaining items:<input type="radio" name="control" value="Destroy inventory"><br>
			Ship to address on file:<input type="radio" name="control" value="Ship to address on file">
		</section>
		<br>
		<input type="submit" value="DELETE">
		
	</form>
	</fieldset>
	<form action="#" method="post">
		
	</form>
	
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>
</html>