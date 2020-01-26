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
		<h1 class="w3-opacity"><b>Domovi planine ${planina.ime }</b></h1>
	</div>
	<table class="w3-table w3-striped w3-bordered">
		<tr>
			<th>Naziv doma</th>
			<th>Slobodna mesta</th>
			<th>Opis</th>
		</tr>
		<c:forEach items="${domovi }" var="d">
			<tr>
				<td>${d.naziv }</td>
				<td>${d.kapacitet }</td>
				<td>${d.opis }</td>
				<td><a href="/Ris/PlaninarController/reservationPage?dom=${d.idDom }">Rezervisi</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>