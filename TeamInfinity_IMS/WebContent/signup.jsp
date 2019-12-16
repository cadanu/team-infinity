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
		<form action="UserControl" method="post">
		
		<input type="hidden" name="action" value="signup"/>
		
		<fieldset>
			<legend>Contact Information</legend>
			<label for="first-name">First Name: </label>
			<input type="text" id="first-name" name="first-name" size="35" required/><br>
			
			<label for="last-name">Last Name: </label>
			<input type="text" id="last-name" name="last-name" size="35" required/><br>
			
			<label for="email">Email Address: </label>
			<input type="email" id="email" name="email" size="50" required/><br>
		</fieldset>
		<br><br>
		<fieldset>
			<legend>Business Information</legend>
			<label for="business-name">Enter the name of your business: </label>
			<input type="text" id="business-name" name="business-name" size="35"/><br>
			
			<label for="street-add">Street Address: </label>
			<input type="text" id="street-add" name="street-add" size="50" required/><br>
			
			<label for="street-add2">Address Line 2 (Optional): </label>
			<input type="text" id="street-add2" name="street-add2" size="50"/><br>
			
			<label for="city">City: </label>
			<input type="text" id="city" name="city" size="20" required/>
			
			<label for="province">Province: </label>
			<input type="text" id="province" name="province" size="5" required/>
			
			<label for="postal">Postal / Zip Code: </label>
			<input type="text" id="postal" name="postal" maxlength=7 size="20" required/><br>
			
<!--
Country drop-down option values retrieved from - "https://www.mediacollege.com/internet/samples/html/country-list.html"
-->
			<label for="country">Country: </label>
			<select id="country" name="country">
    			<option value="" selected disabled>Country...</option>
				<option value="AF">Afghanistan</option>
				<option value="AL">Albania</option>
				<option value="DZ">Algeria</option>
				<option value="AS">American Samoa</option>
				<option value="AD">Andorra</option>
				<option value="AG">Angola</option>
				<option value="AI">Anguilla</option>
				<option value="AG">Antigua & Barbuda</option>
				<option value="AR">Argentina</option>
				<option value="AA">Armenia</option>
				<option value="AW">Aruba</option>
				<option value="AU">Australia</option>
				<option value="AT">Austria</option>
				<option value="AZ">Azerbaijan</option>
				<option value="BS">Bahamas</option>
				<option value="BH">Bahrain</option>
				<option value="BD">Bangladesh</option>
				<option value="BB">Barbados</option>
				<option value="BY">Belarus</option>
				<option value="BE">Belgium</option>
				<option value="BZ">Belize</option>
				<option value="BJ">Benin</option>
				<option value="BM">Bermuda</option>
				<option value="BT">Bhutan</option>
				<option value="BO">Bolivia</option>
				<option value="BL">Bonaire</option>
				<option value="BA">Bosnia & Herzegovina</option>
				<option value="BW">Botswana</option>
				<option value="BR">Brazil</option>
				<option value="BC">British Indian Ocean Ter</option>
				<option value="BN">Brunei</option>
				<option value="BG">Bulgaria</option>
				<option value="BF">Burkina Faso</option>
				<option value="BI">Burundi</option>
				<option value="KH">Cambodia</option>
				<option value="CM">Cameroon</option>
				<option value="CA">Canada</option>
				<option value="IC">Canary Islands</option>
				<option value="CV">Cape Verde</option>
				<option value="KY">Cayman Islands</option>
				<option value="CF">Central African Republic</option>
				<option value="TD">Chad</option>
				<option value="CD">Channel Islands</option>
				<option value="CL">Chile</option>
				<option value="CN">China</option>
				<option value="CI">Christmas Island</option>
				<option value="CS">Cocos Island</option>
				<option value="CO">Colombia</option>
				<option value="CC">Comoros</option>
				<option value="CG">Congo</option>
				<option value="CK">Cook Islands</option>
				<option value="CR">Costa Rica</option>
				<option value="CT">Cote D'Ivoire</option>
				<option value="HR">Croatia</option>
				<option value="CU">Cuba</option>
				<option value="CB">Curacao</option>
				<option value="CY">Cyprus</option>
				<option value="CZ">Czech Republic</option>
				<option value="DK">Denmark</option>
				<option value="DJ">Djibouti</option>
				<option value="DM">Dominica</option>
				<option value="DO">Dominican Republic</option>
				<option value="TM">East Timor</option>
				<option value="EC">Ecuador</option>
				<option value="EG">Egypt</option>
				<option value="SV">El Salvador</option>
				<option value="GQ">Equatorial Guinea</option>
				<option value="ER">Eritrea</option>
				<option value="EE">Estonia</option>
				<option value="ET">Ethiopia</option>
				<option value="FA">Falkland Islands</option>
				<option value="FO">Faroe Islands</option>
				<option value="FJ">Fiji</option>
				<option value="FI">Finland</option>
				<option value="FR">France</option>
				<option value="GF">French Guiana</option>
				<option value="PF">French Polynesia</option>
				<option value="FS">French Southern Ter</option>
				<option value="GA">Gabon</option>
				<option value="GM">Gambia</option>
				<option value="GE">Georgia</option>
				<option value="DE">Germany</option>
				<option value="GH">Ghana</option>
				<option value="GI">Gibraltar</option>
				<option value="GB">Great Britain</option>
				<option value="GR">Greece</option>
				<option value="GL">Greenland</option>
				<option value="GD">Grenada</option>
				<option value="GP">Guadeloupe</option>
				<option value="GU">Guam</option>
				<option value="GT">Guatemala</option>
				<option value="GN">Guinea</option>
				<option value="GY">Guyana</option>
				<option value="HT">Haiti</option>
				<option value="HW">Hawaii</option>
				<option value="HN">Honduras</option>
				<option value="HK">Hong Kong</option>
				<option value="HU">Hungary</option>
				<option value="IS">Iceland</option>
				<option value="IN">India</option>
				<option value="ID">Indonesia</option>
				<option value="IA">Iran</option>
				<option value="IQ">Iraq</option>
				<option value="IR">Ireland</option>
				<option value="IM">Isle of Man</option>
				<option value="IL">Israel</option>
				<option value="IT">Italy</option>
				<option value="JM">Jamaica</option>
				<option value="JP">Japan</option>
				<option value="JO">Jordan</option>
				<option value="KZ">Kazakhstan</option>
				<option value="KE">Kenya</option>
				<option value="KI">Kiribati</option>
				<option value="NK">Korea North</option>
				<option value="KS">Korea South</option>
				<option value="KW">Kuwait</option>
				<option value="KG">Kyrgyzstan</option>
				<option value="LA">Laos</option>
				<option value="LV">Latvia</option>
				<option value="LB">Lebanon</option>
				<option value="LS">Lesotho</option>
				<option value="LR">Liberia</option>
				<option value="LY">Libya</option>
				<option value="LI">Liechtenstein</option>
				<option value="LT">Lithuania</option>
				<option value="LU">Luxembourg</option>
				<option value="MO">Macau</option>
				<option value="MK">Macedonia</option>
				<option value="MG">Madagascar</option>
				<option value="MY">Malaysia</option>
				<option value="MW">Malawi</option>
				<option value="MV">Maldives</option>
				<option value="ML">Mali</option>
				<option value="MT">Malta</option>
				<option value="MH">Marshall Islands</option>
				<option value="MQ">Martinique</option>
				<option value="MR">Mauritania</option>
				<option value="MU">Mauritius</option>
				<option value="ME">Mayotte</option>
				<option value="MX">Mexico</option>
				<option value="MI">Midway Islands</option>
				<option value="MD">Moldova</option>
				<option value="MC">Monaco</option>
				<option value="MN">Mongolia</option>
				<option value="MS">Montserrat</option>
				<option value="MA">Morocco</option>
				<option value="MZ">Mozambique</option>
				<option value="MM">Myanmar</option>
				<option value="NA">Nambia</option>
				<option value="NU">Nauru</option>
				<option value="NP">Nepal</option>
				<option value="AN">Netherland Antilles</option>
				<option value="NL">Netherlands (Holland, Europe)</option>
				<option value="NV">Nevis</option>
				<option value="NC">New Caledonia</option>
				<option value="NZ">New Zealand</option>
				<option value="NI">Nicaragua</option>
				<option value="NE">Niger</option>
				<option value="NG">Nigeria</option>
				<option value="NW">Niue</option>
				<option value="NF">Norfolk Island</option>
				<option value="NO">Norway</option>
				<option value="OM">Oman</option>
				<option value="PK">Pakistan</option>
				<option value="PW">Palau Island</option>
				<option value="PS">Palestine</option>
				<option value="PA">Panama</option>
				<option value="PG">Papua New Guinea</option>
				<option value="PY">Paraguay</option>
				<option value="PE">Peru</option>
				<option value="PH">Philippines</option>
				<option value="PO">Pitcairn Island</option>
				<option value="PL">Poland</option>
				<option value="PT">Portugal</option>
				<option value="PR">Puerto Rico</option>
				<option value="QA">Qatar</option>
				<option value="ME">Republic of Montenegro</option>
				<option value="RS">Republic of Serbia</option>
				<option value="RE">Reunion</option>
				<option value="RO">Romania</option>
				<option value="RU">Russia</option>
				<option value="RW">Rwanda</option>
				<option value="NT">St Barthelemy</option>
				<option value="EU">St Eustatius</option>
				<option value="HE">St Helena</option>
				<option value="KN">St Kitts-Nevis</option>
				<option value="LC">St Lucia</option>
				<option value="MB">St Maarten</option>
				<option value="PM">St Pierre & Miquelon</option>
				<option value="VC">St Vincent & Grenadines</option>
				<option value="SP">Saipan</option>
				<option value="SO">Samoa</option>
				<option value="AS">Samoa American</option>
				<option value="SM">San Marino</option>
				<option value="ST">Sao Tome & Principe</option>
				<option value="SA">Saudi Arabia</option>
				<option value="SN">Senegal</option>
				<option value="RS">Serbia</option>
				<option value="SC">Seychelles</option>
				<option value="SL">Sierra Leone</option>
				<option value="SG">Singapore</option>
				<option value="SK">Slovakia</option>
				<option value="SI">Slovenia</option>
				<option value="SB">Solomon Islands</option>
				<option value="OI">Somalia</option>
				<option value="ZA">South Africa</option>
				<option value="ES">Spain</option>
				<option value="LK">Sri Lanka</option>
				<option value="SD">Sudan</option>
				<option value="SR">Suriname</option>
				<option value="SZ">Swaziland</option>
				<option value="SE">Sweden</option>
				<option value="CH">Switzerland</option>
				<option value="SY">Syria</option>
				<option value="TA">Tahiti</option>
				<option value="TW">Taiwan</option>
				<option value="TJ">Tajikistan</option>
				<option value="TZ">Tanzania</option>
				<option value="TH">Thailand</option>
				<option value="TG">Togo</option>
				<option value="TK">Tokelau</option>
				<option value="TO">Tonga</option>
				<option value="TT">Trinidad & Tobago</option>
				<option value="TN">Tunisia</option>
				<option value="TR">Turkey</option>
				<option value="TU">Turkmenistan</option>
				<option value="TC">Turks & Caicos Is</option>
				<option value="TV">Tuvalu</option>
				<option value="UG">Uganda</option>
				<option value="UA">Ukraine</option>
				<option value="AE">United Arab Emirates</option>
				<option value="GB">United Kingdom</option>
				<option value="US">United States of America</option>
				<option value="UY">Uruguay</option>
				<option value="UZ">Uzbekistan</option>
				<option value="VU">Vanuatu</option>
				<option value="VS">Vatican City State</option>
				<option value="VE">Venezuela</option>
				<option value="VN">Vietnam</option>
				<option value="VB">Virgin Islands (Brit)</option>
				<option value="VA">Virgin Islands (USA)</option>
				<option value="WK">Wake Island</option>
				<option value="WF">Wallis & Futana Is</option>
				<option value="YE">Yemen</option>
				<option value="ZR">Zaire</option>
				<option value="ZM">Zambia</option>
				<option value="ZW">Zimbabwe</option>
    		</select>			
		</fieldset>
		<br><br>
		<fieldset>
			<legend>Security</legend>
			<label for="password">Please enter a secure password: </label>
			<input type="password" id="password" name="password" size="20" required/>
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