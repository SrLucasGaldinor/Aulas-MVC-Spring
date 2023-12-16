<%@page import="controller.ContatoController"%>
<%@page import="model.Contato"%>
<%
	String idContato = request.getParameter("idContato");
	String nome = request.getParameter("nome");
	String email  = request.getParameter("email");
	
	Contato contato = new Contato(Integer.parseInt(idContato), nome, email);
	ContatoController cc = new ContatoController();
	
	if(cc.editar(contato)){
		response.sendRedirect("./consultaContato.jsp");		
	}
 	
 
%>