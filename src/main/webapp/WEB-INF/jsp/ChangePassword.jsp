<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

 </script>
<script type="text/javascript" src="changepassword.js"></script>

<title>Change Password</title>

</head>
<body>
<div id="error" style="display:none">Invalid Input</div>
<form action="changepasswordprocess">
<table>
<tr><td>
<label>New Password</label></td><td>
<input type="password" id="newPassword" name="newPassword" pattern=".{6,}" required></input>
</td></tr>
<tr><td>
<label>Confirm Password</label></td><td>
<input type="password"  id="confirmPassword" pattern=".{6,}" required></input>
</td></tr>
<tr><td><button type="submit" id="submitPassword">Submit</button></td>
<td><input type="button" id="cancel" onclick="Login()" value="Cancel"/></td></tr>
</table>
</form>
</body>
</html>