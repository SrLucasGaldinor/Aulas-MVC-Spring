<%@page import="controller.ContatoController"%>
<%@page import="modelos.Contato"%>
<%
	String nome = request.getParameter("nome");
	String email = request.getParameter("email");
	
	Contato contato = new Contato(0, nome, email);
	ContatoController cc = new ContatoController();
	
	if(cc.salvar(contato)) {
		out.print("Contato salvo com Sucesso. ");
	}
	
%>