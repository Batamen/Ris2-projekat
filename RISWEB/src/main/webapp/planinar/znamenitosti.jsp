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
		<h1 class="w3-opacity"><b>Znamenitosti planine ${planina.ime}</b></h1>
	</div>
	<c:forEach items="${znamenitosti }" var="z">
		<table class="w3-table w3-striped w3-bordered">
		
		<tr>
			<th>Opis</th>
			<th>Tip</th>
			<th>Slike</th>
			<th>Unesite komentar</th>
			<th>Rezervacija</th>
		</tr>
		
			<tr>
				<td>${z.opis }</td>
				<td>${z.tip }</td>
				<td>
					<c:forEach  items="${z.slikaznamenitosts }" var="slika"><img src=${slika.path } width="320" height="270"></c:forEach>
				</td>
				<td>
					<form action="/Ris/PlaninarController/komentarisi?znamenitost=${z.idZnamenitost }&staza=${z.staza.idStaza}&" method="post">
						<textarea rows="10" cols="40" name="komentar"></textarea><br>
						<input type="submit" value="komentarisi">
					</form>
				</td>
				<td>
					<a href="/Ris/PlaninarController/reservationTermin?znamenitost=${z.idZnamenitost }">Rezervisi</a>
				</td>
			</tr>
			</table>
			<table class="w3-table w3-striped w3-bordered">
			<c:if test="${!empty z.komentars }">
				<c:forEach items="${z.komentars }" var="k">
					<tr>
						<td>
							${k.planinar.ime }:
						</td>
						<td style="width:100%">
							<span>${k.opis }</span>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</c:forEach>
				
	</table>
</body>
</html>