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
	<h1 class="w3-opacity"><b>Planine</b></h1>
	</div>
	<table class="w3-table w3-striped w3-bordered">
		
		<tr>
			<th>Naziv Planine</th>
			<th>MNV</th>
			<th>Broj domova</th>
			<th>Broj staza</th>
		</tr>
		<c:forEach items="${planine }" var="p">
			<tr>
				<td>${p.ime }</td>
				<td>${p.mnv }</td>
				<td>${fn:length(p.doms) }-> <a href="/Ris/PlaninarController/getDomoviPlanine?planina=${p.idPlanina }">prikazi domova</a></td>
				<td>${fn:length(p.stazas) }-> <a href="/Ris/PlaninarController/getStazePlanine?planina=${p.idPlanina }">prikazi staza</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>