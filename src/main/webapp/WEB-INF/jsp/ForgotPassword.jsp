<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
   <script type="text/javascript">
   function a(){
		 var ans="${answer}";
		return ans;
	}
   function forg(){
	 var f='${userInvalid}';
	return f;
}

 </script>
<script type="text/javascript" src="forgotpassword.js"></script>

<title>Forgot Password</title>

</head>
<body onload="nouser()">

<div style="display:none" id="error">Invalid Input</div>
<form action="changepassword" method="post">


<table>
<tr><td><label>User Name</label></td><td>
<label id="userName">${registrationservice.userName}</label>
</td></tr>
<tr><td>
<label>Security Question</label></td><td>
<label id="securityQuestion"><c:if test="${not empty securityQuestion}">${securityQuestion}</c:if>
<c:if test="${empty securityQuestion}">Invalid Input</c:if></label></td></tr>
<tr><td>
<label>Answer</label></td><td>
<input id="answer" name="answer" type="text" required></input>
</td></tr>
<tr><td><button type="submit" id="forgotSubmit">Submit</button></td>
<td><button type="button" id="cancel" onclick="Login()">Cancel</button></td></tr>
</table>
</form>

</body>
</html>