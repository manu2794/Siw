<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Nuovo Prodotto</title>
</head>
<body>
	<form action="prodotto" method="post"> <!-- la scorsa volta era get -->
	
	<p> Nome*: <input type = "text" name = "nome" value = "${prodotto.nome}"/> ${errNome}
	
	<p> Descrizione*: <input type = "text" name = "descrizione" value = "${prodotto.descrizione}"/> ${errDescrizione}
	
	<p> Prezzo*: <input type = "text" name = "prezzo" value = "${prodotto.prezzo}"/> ${errPrezzo}
	
	<p> Data scadenza*: <input type = "text" name = "dataScadenza" value = "${prodotto.dataScadenza}" placeholder="es. 01/01/2001"/> ${errDataScadenza}
	
	<p>
	*Campo obbligatorio
	<p>
		<input type = "submit" name = "submit" value = "invia"/>
	</form>
	
	<a href = "prodotto"> Lista Prodotti </a> <!-- href = etc.. equivale ad una get -->
</body>
</html>
