package com.example.aula.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.aula.entities.Local;
import com.example.aula.repositories.LocalRepository;

@RestController
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	LocalRepository repo;
	

	@GetMapping
	public ResponseEntity<List<Local>> consultar() {		
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll()); 
	}
	
	@GetMapping("/{idLocal}")
	public ResponseEntity<Local> consultar(@PathVariable("idLocal") Long idLocal) {
		Optional<Local> opt = repo.findById(idLocal);
		try {
			Local loc = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(loc);			
		} catch (Exception error) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody Local local) {
		repo.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body("Local salvo com Sucesso.");
	}
	
	@PutMapping("/{idLocal}")
	public ResponseEntity<Object> alterar(@PathVariable("idLocal") Long idLocal,
										 @RequestBody Local local) {
		Optional<Local> opt = repo.findById(idLocal);
		try {
			Local loc = opt.get();
			loc.setNome(local.getNome());
			loc.setRua(local.getRua());
			loc.setNumero(local.getNumero());
			loc.setBairro(local.getBairro());
			loc.setCidade(local.getCidade());
			loc.setUf(local.getUf());
			loc.setCep(local.getCep());
			repo.save(loc);
			return ResponseEntity.status(HttpStatus.OK).body(loc);								
		} catch (Exception error) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não Encontrado...");
		}
	}
	
	@DeleteMapping("/{idLocal}")
	public ResponseEntity<Object> deletar(@PathVariable ("idLocal") Long idLocal) {
		Optional<Local> opt = repo.findById(idLocal);
		try {
			Local loc = opt.get();
			repo.delete(loc);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();								
		} catch (Exception error) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não Encontrado...");
		}
	}
}
