package controller;

import dao.DAOContato;
import modelos.Contato;

public class ContatoController {
	
	public boolean salvar(Contato contato) {
		/*Regras de Neg�cio*/
		boolean ok = DAOContato.salvar(contato);
		return ok;
	}
	
	
}
