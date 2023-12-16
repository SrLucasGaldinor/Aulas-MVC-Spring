package com.example.aula.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.entities.Contato;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	List<Contato> contatos = new ArrayList();

	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
		contato.setId(contatos.size() + 1l);
		contatos.add(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contato);
	}

	@PutMapping("/{idContato}")
	public String alterar(@PathVariable("idContato") Long idContato, @RequestBody String contato) {
		return contato;
	}

	@GetMapping
	public ResponseEntity<List<Contato>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(contatos);
	}

	@GetMapping("/{idContato}")
	public ResponseEntity<Contato> consultar(@PathVariable("idContato") Long idContato) {
		for (Contato contato : contatos) {
			if (contato.getId().equals(idContato)) {
				return ResponseEntity.status(HttpStatus.OK).body(contato);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
