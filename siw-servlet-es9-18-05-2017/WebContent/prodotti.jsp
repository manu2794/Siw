<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Prodotti</title>
</head>
<body>
	<ul>
		<c:forEach var="prodotto" items="${prodotti}">
			<li><a href="prodotto?id=${prodotto.id}"> ${prodotto.nome} </a>
			<form action="prodotto" method="post">
			 	<input type="hidden" value="${prodotto.id}" name="id"/>
			    <input type="button" value="cancella" name="comand"/>
			</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>