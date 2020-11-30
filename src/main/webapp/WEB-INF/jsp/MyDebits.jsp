<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:include page="Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Debits</title>

<style>
table#mytable,th,td{
border:1px solid black;
	}
	table#mytable{
	border-collapse:collapse;
	}
	

</style>
</head>
<body>
<c:if test="${empty Payments}"><div id="error">No matching records found</div></c:if>

<table id="mytable">
<tr><th>
To Account
</th>
<th>
Payee Name
</th>
<th>
Amount
</th>
<th>
Remarks
</th>
</tr>
<c:forEach var="pay" items="${Payments}" varStatus="status">
<tr>
<td><label id="accNum${status.count}">ABC20190000<c:out value="${pay.toAccount}"/></label></td>
<td><label id="payeeName${status.count}"><c:out value="${pay.payeeName}"/></label></td>
<td><label id="amount${status.count}"><c:out value="${pay.amount}"/></label></td>
<td><label id="remarks${status.count}"><c:out value="${pay.remarks}"/></label></td>
</tr>

</c:forEach>
</table>


</body>
</html>