<%@page import="controller.ContatoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style.css">
<title>Aula</title>
</head>

<body>
	<h1 class="cor">MVC Aula</h1>
	<label>Nome: </label>
	<input placeholder="Informe Nome">
	<label>Sobrenome: </label>
	<input placeholder="Informe Sobrenome">
	<button class="botao" onclick="gravar()">Gravar</button>

	<%
	out.print("<br>");
	String nome = "Lucas Galdino";
	out.print(nome);
	out.print("<br>");
	out.print(ContatoController.ola(nome));
	%>

	<script>
		function gravar() {
			alert('Hello Mother Fucker !');
		}
	</script>
</body>
</html>