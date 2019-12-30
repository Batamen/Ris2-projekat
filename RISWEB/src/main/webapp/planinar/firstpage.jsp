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
	<c:if test="${!empty planinar }">
		<h3>Welcome ${planinar.ime } ${planinar.prezime }</h3>
		<a href="/Ris/PlaninarController/Planinar">hej</a>
	</c:if>
</body>
</html>