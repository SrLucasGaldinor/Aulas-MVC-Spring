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
import com.example.aula.entities.Compromisso;
import com.example.aula.services.CompromissoService;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

	@Autowired
	CompromissoService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Compromisso>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar());
				}
	
	@GetMapping("/{idCompromisso}")
	public ResponseEntity<Compromisso> consultar(@PathVariable("idCompromisso") Long idCompromisso) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idCompromisso));
	}
	
	@PostMapping
	public ResponseEntity<Compromisso> salvar(@RequestBody Compromisso compromisso) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(compromisso));
	}
	
	@PutMapping("/{idCompromisso}")
	public ResponseEntity<Compromisso> alterar(@PathVariable("idCompromisso") Long idCompromisso,
											   @RequestBody Compromisso compromisso) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idCompromisso, compromisso));
	}
	
	@DeleteMapping("/{idCompromisso}")
	public ResponseEntity<Compromisso> deletar(@PathVariable("idCompromisso") Long idCompromisso) {
		service.deletar(idCompromisso);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
