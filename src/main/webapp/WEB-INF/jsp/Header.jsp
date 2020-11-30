<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

</head>
<body>

<table id="headertab"style="width:100%">
<tr> 
<td width="20%">
<a href="performtransaction">Perform Transaction</a></td>
<td width="15%">
<a href="mycredits">MyCredits</a></td>
<td width="15%">
<a href="mydebits">MyDebits</a></td>
<td width="5%">
<label>Balance</label></td>
<td width="50%">
<label id="balance">${balance}</label></td><td>
<a href="logout">Logout</a></td></tr>
</table>

</body>
</html>