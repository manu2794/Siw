<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Link Prodotti</title>
</head>
<body>
	<ul>
		<c:forEach var="prodotto" items="${prodotti}">
			<li><a href="prodotto?id=${prodotto.id}"> nome =
					${prodotto.nome}</a>
				<form action="prodotto" method="post">
					<input type="hidden" value="${prodotto.id}" name="id" /> <input
						type="submit" value="cancella" name="comand"/>
				</form></li>
		</c:forEach>
	</ul>
</body>
</html>