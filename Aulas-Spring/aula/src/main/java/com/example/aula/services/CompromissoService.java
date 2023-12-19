package com.example.aula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aula.entities.Compromisso;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.repositories.CompromissoRepository;

@Service
public class CompromissoService {

	@Autowired
	CompromissoRepository repo;
	
	public List<Compromisso> consultar() {
		List<Compromisso> lista = repo.findAll();
		return lista;
	}
	
	public Compromisso consultar(Long idCompromisso) {
		Optional<Compromisso> opt = repo.findById(idCompromisso);
		Compromisso comp = opt.orElseThrow(() -> new RecursoNaoEncontrado("Compromisso não Encontrado."));
		return comp;
	}
	
	public Compromisso salvar(Compromisso compromisso) {
		repo.save(compromisso);
		return compromisso;
	}
	
	public Compromisso alterar(Long idCompromisso, Compromisso compromisso) {
		Compromisso comp = consultar(idCompromisso);
		repo.save(comp);
		return comp;
	}
	
	public void deletar(Long idCompromisso) {
		Compromisso comp = consultar(idCompromisso);
		repo.delete(comp);
	}
}
