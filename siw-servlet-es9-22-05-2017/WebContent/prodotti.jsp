<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Prodotti</title>
</head>
<body>
	Lista Prodotti:
	<ul>				<!-- questo era controllerDati -->
		<c:forEach var="prodotto" items="${prodotti}">							
			<li><a href="prodotto?id=${prodotto.id}"> ${prodotto.nome}</a>		<!-- stiamo componendo un URL con il link al prodotto -->
				<form action="prodotto" method="post"> 							<!-- mettiamo un bottone per cancellare un prodotto --> 
					<input type="hidden" value="${prodotto.id}" name="id" />	<!-- dobbiamo passare il parametro che indica il prodotto da cancellare -->
					<input type="submit" value="rimuovi" name="comand"/>
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
