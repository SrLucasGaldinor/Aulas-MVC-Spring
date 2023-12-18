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
import com.example.aula.entities.Local;
import com.example.aula.services.LocalService;

@RestController
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	LocalService service;
	

	@GetMapping
	public ResponseEntity<List<Local>> consultar() {		
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar()); 
	}
	
	@GetMapping("/{idLocal}")
	public ResponseEntity<Local> consultar(@PathVariable("idLocal") Long idLocal) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idLocal)); 
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody Local local) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(local));
	}
	
	@PutMapping("/{idLocal}")
	public ResponseEntity<Object> alterar(@PathVariable("idLocal") Long idLocal,
										 @RequestBody Local local) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idLocal, local)); 
	}
	
	@DeleteMapping("/{idLocal}")
	public ResponseEntity<Object> deletar(@PathVariable ("idLocal") Long idLocal) {
		service.deletar(idLocal);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}
}
