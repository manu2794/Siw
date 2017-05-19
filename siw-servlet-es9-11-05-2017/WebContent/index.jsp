<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Nuovo Prodotto</title>
</head>
<body>
	<form action="prodotto" method="get">
	<div>Nome*: <input type="text" name="nome" value="${nome}" /> ${errNome} </div>
	<div>Descrizione*: <input type="text" name="nome" value="${descrizione}" /> ${errDescrizione} </div>
	<div>Prezzo*: <input type="text" name="nome" value="${prezzo}" /> ${errPrezzo} </div>
	<div>DataScadenza*: <input type="text" name="nome" value="${dataScadenza}" /> ${errDataScadenza} </div>
	<div>*Campo Obbligatorio</div>
		
		<input type="submit" name="sumbit" value="invia" />
	</form>
</body>
</html>