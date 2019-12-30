<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Ris/PlaninarController/logPlaninar" method=post>
		<p> Unesite ime </p> <input type="text" name="ime"> 
		<p> Unesite prezime </p> <input type="text" name="prezime">
		<input type="submit" value="Register">
	</form>
<c:if test="${!empty poruka}">
	<p>${poruka }</p>
</c:if>
</body>
</html>