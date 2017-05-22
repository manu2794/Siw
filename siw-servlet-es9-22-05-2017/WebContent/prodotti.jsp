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
	<ul>
		<c:forEach var="prodotto" items="${prodotti}">
			<li>nome = ${prodotto.nome}; prezzo = ${prodotto.prezzo}, data
				di scadenza = ${prodotto.dataScadenza}</li>
		</c:forEach>
	</ul>
</body>
</html>