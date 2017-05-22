<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Prodotto</title>
</head>
<body>
	<form action="prodotto" method="post">
		<div>
			Nome*:<input type="text" name="nome" value='${prodotto.nome}' /> ${errNome}
		</div>
		<div>
			Descrizione*:<input type="text" name="descrizione" value='${prodotto.descrizione}' />
			${errDescrizione}
		</div>
		<div>
			Prezzo*:<input type="text" name="prezzo" value='${prodotto.prezzo}' />
			${errPrezzo}
		</div>
		<div>
			Data di Scadenza*:<input type="text" name="dataScadenza"
				value='${prodotto.dataScadenza}' /> ${errDataScadenza}
		</div>
		<div> * = campo obbligatorio</div>
		<input type="submit" name="submit" value="invia" />
	</form>
	<a href="prodotto">Lista Prodotti</a>
	
</body>
</html>