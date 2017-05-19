<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostra Dati</title>
</head>
<body>
	<p>Hai inserito: </p>
	<p>Nome: <% out.print(request.getParameter("nome")); %> </p> 
	<p>Cognome: <% out.println(request.getParameter("cognome"));%></p>
</body>
</html>