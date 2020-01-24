<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container w3-teal w3-center">
		<h1 class="w3-opacity"><b>Staze planine ${planina.ime}</b></h1>
	</div>
		<table class="w3-table w3-striped w3-bordered">
		
		<tr>
			<th>Opis</th>
			<th>Mapa</th>
			<th>Tezina</th>
			<th>Znamenitost</th>
		</tr>
		<c:forEach items="${staze }" var="s">
			<tr>
				<td>${s.opis }</td>
				<td>
					<c:forEach  items="${s.mapas }" var="mapa"><img src=${mapa.path } width="250" height="250"></c:forEach>
				</td>
				<td>${s.tezina }</td>
				<td><a href="/Ris/PlaninarController/getZnamenitosti?staza=${s.idStaza}">Znamenitosti</a></td>
			</tr>
		</c:forEach>
				
	</table>
</body>
</html>