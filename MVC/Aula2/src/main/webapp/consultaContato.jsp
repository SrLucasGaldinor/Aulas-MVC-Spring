<%@page import="model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoContato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./bootstrap.jsp"%>
<title>Consulta de Contatos</title>
</head>

<body>
	<nav>
		<%@ include file="./menu.jsp"%>
	</nav>
	<table class="table table-striped table-light">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Contato> contatos = DaoContato.consultar();
			for (Contato ct : contatos) {
				out.print("<tr>");
				out.print("<td>" + ct.getId() + "</td>");
				out.print("<td>" + ct.getNome() + "</td>");
				out.print("<td>" + ct.getEmail() + "</td>");
				out.print("<td><a href='./formEditarContato.jsp?id=" + ct.getId() + "'>Editar</a></td>");
				out.print("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>