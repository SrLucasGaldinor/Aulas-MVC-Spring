<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Contatos</title>
</head>
<body>
	<div>
		<nav>
			<%@ include file="./menu.jsp"%>
		</nav>
		<h1>Cadastro de Contatos</h1>
		<form action="gravarContato.jsp">
			<label>Nome - </label> <input type="text" placeholder="Insira Nome"
				name="nome"> <label>E-mail - </label> <input type="text"
				placeholder="Insira E-mail" name="email">
			<button>Gravar</button>
		</form>
	</div>
</body>
</html>