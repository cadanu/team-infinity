<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/design.css"/>
	<title>Team Infinity: User Authentication</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
	<div><h2 style="color: red">Please enter your login credentials.</h2><br><br>
		<form action="UserControl" method="post">
			
			<input type="hidden" name="action" value="login"/>
			
			<label for="usr">Username: </label>
			<input type="email" id="usr" name="usr" size="20" value="${email}" required/>
			<label for="pss">Password: </label>
			<input type="password" id="pss" name="pss" size="20" required/>
			
			<input type="submit" value="Login"/>
		</form><br><br>
	</div>
</div>

<footer><div><jsp:include page="footer.jsp"/></div></footer>

</body>
</html>