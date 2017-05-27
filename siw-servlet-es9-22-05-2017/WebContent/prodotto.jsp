<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Prodotto</title>
</head>
<body>
	<h1>Nome: ${prodotto.nome}</h1>
	<div>Descrizione: ${prodotto.descrizione}</div>
	<div>Prezzo: ${prodotto.prezzo}</div>
	<div>Data di Scadenza: ${prodotto.dataScadenza}</div>
</body>
</html>

<!-- prodotti diventa quella dell'altra volta con il forEach -->