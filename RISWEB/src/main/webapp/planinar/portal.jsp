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
	<h1 class="w3-opacity"><b>Portal</b></h1>
	</div>
	<table class="w3-table w3-striped w3-bordered">
		
		<tr>
			<th>Planinar</th>
			<th>Iskustva</th>
			<th>Slike</th>
		</tr>
		<c:forEach items="${portali }" var="p">
			<tr>
				<td>${p.planinar.ime }</td>
				<td>${p.iskustva }</td>
				<td><c:forEach items="${p.slikeportals }" var="s"><img src="${s.path }" width="250" height="250"> </c:forEach></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>