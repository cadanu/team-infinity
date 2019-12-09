<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<title>Team Infinity: Sign Up</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div>
		<p style="color: blue;">You've taken a step in the right direction. With Infinity Management System by Team Infinity<sup>TM</sup>, inventory management is accessible and intuitive.<br>
			After sign-up you will be taken to our welcome screen, where you will be able to select an IMS package that suits your businesses needs. Or you can call us<br>
			toll-free at 1-800-555-TIMS. Our customer support agents are standing by to assist you.<br>			
		</p>
		<br><h2 style="color: red;">Please fill out the sign up form below then press submit.</h2><br><br>
		<form action="#" method="post">
		<fieldset>
			<legend>Contact Information</legend>
			<label for="first-name">First Name: </label>
			<input type="text" id="first-name" name="first-name" size="35" required/><br>
			
			<label for="last-name">Last Name: </label>
			<input type="text" id="last-name" name="last-name" size="35" required/><br>
			
			<label for="email-address">Email Address: </label>
			<input type="text" id="email-address" name="email-address" size="50" required/><br>
		</fieldset>
		<br><br>
		<fieldset>
			<legend>Business Information</legend>
			<label for="business-name">Enter the name of your business: </label>
			<input type="text" id="business-name" name="business-name" size="35" required/><br>
			
			<label for="street-address">Street Address: </label>
			<input type="text" id="street-address" name="street-address" size="50" required/><br>
			
			<label for="address2">Address Line 2 (Optional): </label>
			<input type="text" id="address2" name="address2" size="50"/><br>
			
			<label for="city">City: </label>
			<input type="text" id="city" name="city" size="20" required/>
			
			<label for="province">Province: </label>
			<input type="text" id="province" name="province" size="5" required/>
			
			<label for="postal">Postal Code: </label>
			<input type="text" id="postal" name="postal" size="20" required/>
		</fieldset>
			
			<br><br>
			<input type="submit" value="Submit"/>
			<br><br><br>
		</form>
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>

</body>
</html>