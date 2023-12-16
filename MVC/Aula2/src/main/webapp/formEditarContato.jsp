<%@page import="model.Contato"%>
<%@page import="controller.ContatoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./bootstrap.jsp" %>
<title>Editar Contatos</title>
</head>
<body>
	<div class="container">
		<nav>
			<%@ include file="./menu.jsp"%>
		</nav>
		
		<%
			String idContato = request.getParameter("id");
			Contato contato = new ContatoController().consultarPorID(Integer.parseInt(idContato));
		%>
		
		<h1 class="text-center">Editar Contatos</h1>
		<form action="editarContato.jsp" method="POST">
		
			<label class="form-label">ID</label> 
			<input class="form-control" type="text" readonly="readonly" name="idContato" value="<% out.print(idContato); %>">
			
			<label class="form-label">Nome</label> 
			<input class="form-control" type="text" placeholder="Insira Nome" name="nome" value="<% out.print(contato.getNome()); %>">
			
			<label class="form-label">E-mail</label> 
			<input class="form-control" type="text" placeholder="Insira E-mail" name="email" value="<% out.print(contato.getEmail()); %>">
			
			<button class="btn btn-primary mt-2">Editar</button>
		</form>
	</div>
</body>
</html>