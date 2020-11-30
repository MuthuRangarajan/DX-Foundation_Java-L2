<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
 <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
 <script type="text/javascript" src="login.js"></script>
<script type="text/javascript">
function b(){
	 var x='${SPRING_SECURITY_LAST_EXCEPTION.message}';
	return x;
}

 </script>


<title>Login</title>


</head>

<body onload="errordiv()">
<div id="error" style="display:none">Invalid Input</div> 

<form action="login" method="POST">

<table style="width:100%">
<tr><td>
<label >User Name</label></td>
<td><input type="text" id="userName" name="userName" required/></td>

</tr>

<tr><td>

<label>Password</label></td>
<td><input type="password" id="password" name="password" required/>
</td></tr>
<tr><td>
<button id="login" type="submit">Login</button></td></tr>

</table>
<button id="register" onclick="Registration()" >Register</button>
<a id="userdata" href="forgotpassword">ForgotPassword</a>
</form>



</body>
</html>