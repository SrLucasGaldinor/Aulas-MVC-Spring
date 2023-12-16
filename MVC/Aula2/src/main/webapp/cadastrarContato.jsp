<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./bootstrap.jsp" %>
<title>Cadastro de Contatos</title>
</head>
<body>
	<div class="container">
		<nav>
			<%@ include file="./menu.jsp"%>
		</nav>
		<h1 class="text-center">Cadastro de Contatos</h1>
		<form action="gravarContato.jsp" method="POST">
		
			<label class="form-label">Nome</label> 
			<input class="form-control" type="text" placeholder="Insira Nome" name="nome">
			
			<label class="form-label">E-mail</label> 
			<input class="form-control" type="text" placeholder="Insira E-mail" name="email">
			
			<button class="btn btn-primary mt-2">Gravar</button>
		</form>
	</div>
</body>
</html>