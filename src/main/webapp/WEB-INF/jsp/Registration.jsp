<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript" src="jquery-3.2.1.min.js"></script>

 <script type="text/javascript">
function r(){

	var f ='${usernamelist}';
			return f;
}

 </script>
 <script type="text/javascript" src="registration.js"></script>

<meta charset="ISO-8859-1">
<title>Registration</title>

</head>
<body>  
<form action="registrationservice" method="post">

<div id="error" style="display:none ">Invalid Input</div>
<table>
<tr><td>
<label>Account Number</label></td><td>
<label id="accountNumber">${accountNumber}</label>
</td></tr>
<tr><td>
<label>Account Type</label></td><td>
<label id="accountType"><b>Savings</b></label>
</td></tr>
<tr><td>
<label>User Name</label></td><td>
<input id="userName" name="userName" pattern=".{6,}" type="text" required></input>
</td></tr>
<tr><td>
<label>Password</label></td><td>
<input type="password" id="password" name="password"  pattern=".{6,}"  required></input>
</td></tr>
<tr><td>
<label>Confirm Password</label></td><td>
<input type="password" id="confirmPassword"  pattern=".{6,}"  required></input>
</td></tr>
<tr><td>
<label>Gender</label></td><td>
<select id="gender">
<option>Male</option>
<option>Female</option>
</select></td></tr>
<tr><td>
<label>Email</label></td><td>
<input type="email" id="email" name="email" required></input></td></tr>
<tr><td>
<label>Address</label></td><td>
<input type="text" id="address" required></input></td></tr>
<tr><td>
<label>Security Question</label></td><td>
<select id="securityQuestion" name="securityQuestion">
<option>Where did you have your primary education?</option>
<option>What is your mother's maiden name?</option>
<option>Who is your favorite actor?</option>
</select></td></tr>
<tr><td>
<label>Answer</label></td><td>
<input id="answer" name="answer" type="text" required></input>
</td></tr>
<tr><td>
<label>Initial Amount</label></td><td>
<input type="number" id="amount" name="amount" min="1" pattern=".{1,5}" required></input></td></tr>
<tr><td>
<button type="submit" id="submitButton">Submit</button></td><td>
<button onclick="Login()" id="cancel">Cancel</button>
 </td></tr>

</table>
</form>
</body>
</html>