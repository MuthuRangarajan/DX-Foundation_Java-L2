<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <jsp:include page="Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
function b(){
	 var bal="${balance}";
	return bal;
}

 </script>
<script type="text/javascript" src="performtransaction.js"></script>

<title>Perform Transaction</title>

</head>
<body>
<div id="error" style="display:none">Invalid Input</div>
<form action="mydebitsprocess" method="post">
<table>
<tr><td><label>Payee Account Number</label></td>
<td>
<select id="payeeAccountNumber" name="payeeAccountNumber">
 <option>Please Select Account Number</option>
   
    <c:forEach var="accno" items="${Accountnumbers}">
     
        <c:choose>
        <c:when test="${accno!= Loggeduser}">
        <option>ABC20190000<c:out value="${accno}"/></option>
        </c:when> 
        </c:choose>
       
    </c:forEach>
 </select>
</td></tr>

<tr><td>
<label>Payee Name</label></td><td>
<input id="payeeName" name="payeeName" type="text"></input>
</td></tr>


<tr><td>
<label>Mobile Number</label></td><td>
<input id="mobileNumber" name="mobileNumber" type="number" required></input>
</td></tr>

<tr><td>
<label>Amount</label></td><td>
<input id="amount" name="amount" type="number" min="1" pattern=".{1,5}" required></input>
</td></tr>

<tr><td>
<label>Remarks</label></td><td>
<input id="remarks" name="remarks" type="text" required></input>
</td></tr>

<tr><td><button type="submit" id="send">Send</button></td>
<td><button id="btnCancel" onclick="PerformTransaction()" >Cancel</button></td></tr>
</table>


</form>
</body>
</html>