package com.example.aula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aula.entities.Local;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.repositories.LocalRepository;

@Service
public class LocalService {

	@Autowired
	LocalRepository repo;
	
	public List<Local> consultar() {
		List<Local> lista = repo.findAll();
		return lista;
	}
	
	public Local consultar(Long idLocal) {
		Optional<Local> opt = repo.findById(idLocal);
		Local loc = opt.orElseThrow(() -> new RecursoNaoEncontrado("Local não Encontrado."));
		return loc;
	}
	
	public Local salvar(Local local) {
		repo.save(local);
		return local;
	}
	
	public Local alterar(Long idLocal, Local local) {
		Local loc = consultar(idLocal);
		loc = local;
		repo.save(loc);
		return loc;
	}
	
	public void deletar(Long idLocal) {
		Local loc = consultar(idLocal);
		repo.delete(loc);
	}
}
