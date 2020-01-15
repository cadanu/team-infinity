<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<div style="color:red;"><h3>IMS: Product Summary and Update</h3></div>
	
	<span><a href="#" rel="#">&#60; Previous Product &#60;</a></span>|<span><a href="#" rel="#">> Next Product ></a></span>
	
	<div style="position:absolute;margin:60px 0 0 20px;border-right:3px solid silver;color:blue;max-width:150px;padding:10px">
		<span ><a href="add.jsp" rel="Add Records">Add Product</a></span><br><br>
		<span ><a href="remove.jsp" rel="Remove Records">Remove Product</a></span>
	</div>
	
	<div id="summary-box" style="">
	
	<fieldset>
	<legend><b>Product Summary</b></legend>
	<form action="#" method="post">
		<table><th>${productName}</th>
				<tr><td>Amount in stock:</td></tr>
			<tr><td><input type="number" name="amount" value="${amount}"></td>
				<tr><td>Reorder amount:</td>
				<td><input type="number" name="reorder-amount" value="${reorder-amount}"></td></tr>
				<tr><td>Location in storage:</td></tr>
			<tr><td><input type="text" name="location" value="${location}"></td></tr>
				<tr><td>Price per item:</td></tr>
			<tr><td><input type="number" name="price" value="${price}"></td></tr>
				<tr><td>Description:</td></tr>
			<tr><td><input class="textarea" type="text" name="description" value="${description}"></td></tr>
			
		</table>
	</form>
	</fieldset>
	<form action="#" method="post">
		
	</form>
	
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>
</html>