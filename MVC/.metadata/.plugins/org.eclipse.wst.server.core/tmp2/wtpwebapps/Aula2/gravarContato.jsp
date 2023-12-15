<%@page import="controller.ContatoController"%>
<%@page import="model.Contato"%>
<%
	String nome = request.getParameter("nome");
	String email  = request.getParameter("email");
	
	Contato contato = new Contato(0, nome, email);
	ContatoController cc = new ContatoController();
	
	if(cc.salvar(contato)){
		out.print("Contato Salvo com Sucesso.");		
	}
 	
 
%>