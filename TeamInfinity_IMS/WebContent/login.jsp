<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<title>Team Infinity: User Authentication</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div><h2 style="color: red">Please enter your login credentials.</h2><br><br>
		<form action="#" method="post">
			<label for="user-name">Username: </label>
			<input type="text" id="user-name" name="user-name" size="20" required/>
			<label for="password">Password: </label>
			<input type="text" id="password" name="password" size="20" required/>
			
			<input type="submit" value="Login"/>
		</form><br><br>
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>

</body>
</html>