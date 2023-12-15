package controller;

import dao.DaoContato;
import model.Contato;

public class ContatoController {
	
	public boolean salvar(Contato contato) {
		/*Regras de Negócio*/
		boolean ok = DaoContato.salvar(contato);
		return ok;
	}
}
