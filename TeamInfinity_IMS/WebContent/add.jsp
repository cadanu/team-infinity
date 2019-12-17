<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<title>IMS: Add Product</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div style="color:red;"><h3>IMS: Add Product to Inventory</h3></div>
	
	<!-- <span><a href="#" rel="#">&#60; Previous Product &#60;</a></span>|<span><a href="#" rel="#">> Next Product ></a></span> -->
	
	<div style="position:absolute;margin:60px 0 0 20px;border-right:3px solid silver;color:blue;max-width:150px;padding:10px">
		<span ><a href="products.jsp" rel="Update Records">Update Product</a></span><br><br>
		<span ><a href="remove.jsp" rel="Remove Records">Remove Product</a></span>
	</div>
	
	<div id="product-summary" style="position:absolute;right:38%;">
	
	<fieldset>
	<legend><b>Add Product</b></legend>
	<form action="#" method="post">
		<input type="hidden" name="action" value="add">
		<table>
			
				<tr><td>Product Name:</td></tr>
			<tr><td><input type="text" name="product-name" placeholder="Enter product details..."></td>
				<tr><td>Amount of stock:</td></tr>
			<tr><td><input type="number" name="stock-amount" value="${amount}"></td>
				<tr><td>Reorder amount:</td>
				<td><input type="number" name="reorder-amount" value="${reorder-amount}"></td></tr>
				<tr><td>Location:</td></tr>
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