<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-teal w3-center">
	<h1 class="w3-opacity"><b>Profil ${planinar.ime }</b></h1>
</div>
<div class="w3-container w3-center">
	<p>${planinar.ime } imate ukupno ${fn:length(planinar.rezervacijas)} rezervacija</p><br>
	<table class="w3-table w3-striped w3-bordered">
		<tr>
			<th>Dom</th>
			<th>Planina</th>
			<th>Datum</th>
		</tr>
		<c:forEach items="${planinar.rezervacijas }" var="r">
			<tr>
				<td>${r.dom.naziv }</td>
				<td>${r.dom.planina.ime }</td>
				<td>${r.datum }</td>
				<td><a href="/Ris/PlaninarController/ukloni?rezervacija=${r.idRezervacija}">Ukloni</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="#" method="get" enctype = "multipart/form-data">
		<textarea rows="10" cols="100"></textarea><br>
		<input type="file" name="picture" size="50">
		<input type="submit" value="Zakaci post">
	</form>
	<c:if test="${!empty postovi }"></c:if>
</div>
</body>
</html>