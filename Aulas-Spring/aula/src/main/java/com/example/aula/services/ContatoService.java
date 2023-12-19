package com.example.aula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aula.entities.Contato;
import com.example.aula.exceptions.RecursoJaCadastrado;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.exceptions.RecursoNaoInformado;
import com.example.aula.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repo;

	public Contato consultar(Long idContato) {
		
		Optional<Contato> opt = repo.findById(idContato);
		Contato contato = opt.orElseThrow(() -> new RecursoNaoEncontrado("Contato não Encontrado."));
		return contato;
	}

	public List<Contato> consultar() {
		List<Contato> lista = repo.findAll();
		return lista;
	}

	public Contato alterar(Long idContato, Contato contato) {
		Contato ct = consultar(idContato);
		validarCamposVazios(contato);
		validarDadosJaExistentes(contato);	
		ct = contato;
		repo.save(ct);
		return ct;
	}
	
	public Contato salvar(Contato contato) {
		validarCamposVazios(contato);
		validarDadosJaExistentes(contato);
		repo.save(contato);
		return contato;
	}
	
	public void validarDadosJaExistentes(Contato contato) {
		List<Contato> lista = consultar();
		for(Contato con : lista) {
			if(con.getEmail().equals(contato.getEmail())) {
				throw new RecursoJaCadastrado("Email já cadastrado no Banco de Dados.");
			}
		}
	}
	
	public void validarCamposVazios(Contato contato) {
		if(contato.getNome() == null | contato.getNome() == "" |
		   contato.getEmail() == null | contato.getEmail() == "" |
		   contato.getFone() == null | contato.getFone() == "" ) {
			throw new RecursoNaoInformado("Os campos Obrigatórios devem ser Informados.");
		}	
	}

	public void deletar(Long idContato) {
			Contato contato = consultar(idContato);
			repo.delete(contato);
	}
}
