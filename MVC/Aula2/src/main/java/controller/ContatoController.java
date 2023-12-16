package controller;

import dao.DaoContato;
import model.Contato;

public class ContatoController {
	
	public boolean salvar(Contato contato) {
		/*Regras de Negócio*/
		boolean ok = DaoContato.salvar(contato);
		return ok;
	}
	
	public boolean editar(Contato contato) {
		/*Regras de Negócio*/
		boolean ok = DaoContato.editar(contato);
		return ok;
	}
	
	public Contato consultarPorID(int id) {
		Contato ct = DaoContato.consultar(id);
		/*Regras de Negócio*/
		return ct;
	}
}
