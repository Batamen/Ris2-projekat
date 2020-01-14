<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container w3-teal w3-center">
		<h1 class="w3-opacity"><b>Dobro dosli</b></h1>
	</div>
	<div class="w3-container w3-center">
	<form action="/Ris/PlaninarController/logPlaninar" method=post>
		<p style="text-shadow:1px 1px 0 #444"> Unesite ime </p> <input type="text" name="ime"> 
		<p style="text-shadow:1px 1px 0 #444"> Unesite vas clanski broj </p> <input type="text" name="clanskibroj"><br><br>
		<input class="w3-btn w3-teal" type="submit" value="LogIn">
	</form>
	<c:if test="${!empty poruka}">
		<p>${poruka }</p>
	</c:if>
</div>
</body>
</html>