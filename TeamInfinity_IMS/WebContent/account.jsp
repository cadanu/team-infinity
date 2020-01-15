<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/design.css"/>
	<title>Team Infinity: Infinity Management System</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div><h3>Account Page</h3></div>
	
	<div style="position:absolute;margin:60px 0 0 20px;border-right:3px solid silver;color:blue;max-width:200px;padding:10px">
		<span ><a href="products.jsp" rel="Manage your inventory">Manage Inventory</a></span><br><br>
	</div>
	
	<div id="summary-box" style="position:absolute;right:30%;border:1px solid silver;padding:20px;">
	<fieldset>
	<legend>Account Summary</legend>
	<form action="#" method="post">
		<table>
			<tr><th>User Information</th></tr>
			<tr>
				<td><input type="text" name="first-name" value="${firstName}"></td><td><input type="text" name="last-name" value="${lastName}"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value="${email}"></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr><th>Business Information</th></tr>
			<tr>
				<td><input type="text" name="business-name" value="${businessName}"></td>
			</tr>
			<tr>
				<td><input type="text" name="street-add" value="${streetAdd}"></td><td><input type="text" name="street-add2" value="${streetAdd2}"></td>
			</tr>
			<tr>
				<td><input type="text" name="city" value="${city}"></td><td><input type="text" name="province" value="${province}"></td>
				<td><input type="text" name="postal" value="${postal}"></td>
			</tr>
			<tr>
				<td><input type="text" name="country" value="${country}"></td>
			</tr>
		</table>
	</form>
	</fieldset>
	<input type="submit" value="Update Information">
	<form action="#" method="post">
		
	</form>
	
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>

</body>
</html>