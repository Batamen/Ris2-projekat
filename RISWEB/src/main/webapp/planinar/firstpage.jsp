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
		<c:if test="${!empty planinar }">
			<h1 class="w3-opacity"><b>Dobro dosao ${planinar.ime } ${planinar.prezime }</b></h1>
		</c:if>
	</div>
	<div class="w3-container w3-light-blue w3-center">
	<pre><a href="/Ris/PlaninarController/getPlanine">Planine</a>				<a href="/Ris/PlaninarController/getPlaninari">Planinari</a>				<a href="/Ris/PlaninarController/getProfil">Profil</a></pre>
	</div>
	<c:if test="${!empty poruka }">
		<h3 class="w3-center">Cestitam na rezervaciji</h3>
	</c:if>
</body>
</html>