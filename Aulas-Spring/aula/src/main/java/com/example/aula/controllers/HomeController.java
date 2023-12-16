package com.example.aula.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/ola")
	public String olaMundo() {
		return "Hello World !";
	}

	@GetMapping("/ola/{nome}")
	public String olaMundo(@PathVariable("nome") String nome) {
		return "Hello World !" + nome;
	}
}
