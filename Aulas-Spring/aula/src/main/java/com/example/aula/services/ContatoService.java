package com.example.aula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aula.entities.Contato;
import com.example.aula.exceptions.RecursoNaoEncontrado;
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

		Optional<Contato> opt = repo.findById(idContato);
		Contato ct = opt.orElseThrow(() -> new RecursoNaoEncontrado("Contato não Encontrado"));
		ct.setNome(contato.getNome());
		ct.setEmail(contato.getEmail());
		ct.setFone(contato.getFone());
		repo.save(ct);
		return ct;
	}
	
	public Contato salvar(Contato contato) {
		repo.save(contato);
		return contato;
	}
	

	public void deletar(Long idContato) {

		Optional<Contato> opt = repo.findById(idContato);
			Contato contato = opt.orElseThrow(() -> new RecursoNaoEncontrado("Contato não Encontrado."));
			repo.delete(contato);
	}
}
