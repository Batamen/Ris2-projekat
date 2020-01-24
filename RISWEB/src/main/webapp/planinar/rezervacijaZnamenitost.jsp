<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-teal w3-center">
	<h1 class="w3-opacity"><b>${planinar.ime } rezervisite ${znamenitost.tip } na ${planina.ime }</b></h1>
</div>
<div class="w3-container w3-center">
	<form action="/Ris/PlaninarController/rezervisiZ" method="post">
	Unesite datum kada zelite da rezervisete   <input type="date" name="datum"><br>
	<input type="submit" value="Rezervisi">
	</form>
</div>
</body>
</html>