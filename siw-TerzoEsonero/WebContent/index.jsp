<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento opere</title>
</head>
<body>
	<form action="opera" method="post" >
		<div>Titolo*: <input type="text" name="titolo" value="${Opera.titolo}" /> </div>
		<div>Tecnica*: <input type="text" name="tecnica" value="${Opera.tecnica}" /> </div>
		<div>Anno*: <input type="text" name="anno" value="${Opera.anno}" /> </div>
		
		Scegli Artista: 
		<select name="artisti">
			<c:forEach var="artistaId" items="${opere}" >
				<option value="artista?id=${autore.id}"> ${autore.nome} </option>
			</c:forEach>
		</select>
		<input type="hidden" name="id" value="${artista.id}" />
		<input type="submit" name="comand" value="invia" />
	</form>
</body>
</html>
		
		
			
			
			
			
			
	
</body>
</html>