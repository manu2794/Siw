<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ottava Pagina</title>
</head>
<body>
	<form action="ControllerDati" method="get">
		<p>Inserire:
		<p> Nome: <input type="text" name="nome" value="${nome}" />  ${errNome}
		<p> Cognome: <input type="text" name="cognome" value="${cognome}" /> ${errCognome}
		
		<p> <input type="submit" name="submit" value="invia" />
	</form>
</body>
</html>