<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<title>Team Infinity: Welcome!</title>
</head>
<body>

<header><div><jsp:include page="header.jsp"/></div></header>

<div id="main-container">
Welcome! Please choose from the following packages.<br>
	<form action="#" method="get">
		<div id="package-select">
			<div class="packages"><h2 align="center">Good Package</h2>
			</div>
			
			<div class="packages"><h2 align="center">Best Package</h2>
			</div>
		</div>
	</form>
</div>
<br><br><br><br>
<footer><div><jsp:include page="footer.jsp"/></div></footer>

</html>