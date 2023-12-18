package com.example.aula.controllers;

import java.util.List;
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
import com.example.aula.entities.Contato;
import com.example.aula.services.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	ContatoService service;
	
	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(contato));
	}

	@PutMapping("/{idContato}")
	public ResponseEntity<Object> alterar(@PathVariable("idContato") Long idContato, @RequestBody Contato contato) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idContato, contato));
	}

	@GetMapping
	public ResponseEntity<List<Contato>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar());
	}

	@GetMapping("/{idContato}")
	public ResponseEntity<Object> consultar(@PathVariable("idContato") Long idContato) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idContato));
	}

	@DeleteMapping("/{idContato}")
	public ResponseEntity<Object> deletar(@PathVariable("idContato") Long idContato) {
		service.deletar(idContato);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
