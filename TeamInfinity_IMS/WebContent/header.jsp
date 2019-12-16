<div id="top-name">
<h1 class="extra-padding">Infinity Management System</h1>
</div>
<span id="top-button-box">
	
		<span class="top-button"><a href="index.jsp" rel="Home button">Home</a></span>
	
	<% if(session.getAttribute("email") != null) { %>
		<!-- 
		<span class="top-button"><a href="login.jsp" rel="Login Button" style="display:none;position:absolute;">Login</a></span>
		<span class="top-button"><a href="signup.jsp" rel="Sign Up Button" style="display:none;position:absolute;">Sign Up</a></span>
		-->
		<span class="top-button"><a href="account.jsp" rel="My Account">Account</a></span>
		<span class="top-button"><a href="logout.jsp" rel="Logout Button">Logout</a></span>
		
	<% } else { %>
		
		<span class="top-button"><a href="login.jsp" rel="Login Button">Login</a></span>
		<span class="top-button"><a href="signup.jsp" rel="Sign Up Button">Sign Up</a></span>
		<!-- 
		<span class="top-button"><a href="account.jsp" rel="My Account" style="display:none;position:absolute;">Account</a></span>
		<span class="top-button"><a href="logout.jsp" rel="Logout Button" style="display:none;position:absolute;">Logout</a></span>
		-->
	
	<% } %>
	
	
</span>