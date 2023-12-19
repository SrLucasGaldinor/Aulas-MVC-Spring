package com.example.aula.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<StandardError> entidadeNaoEncontrada(RecursoNaoEncontrado exc, HttpServletRequest requi) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não Encontrado.");
		err.setMessage(exc.getMessage());
		err.setPath(requi.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(RecursoJaCadastrado.class)
	public ResponseEntity<StandardError> entidadeJaCadastrada(RecursoJaCadastrado exc, HttpServletRequest requi) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Recurso Já Cadastrado.");
		err.setMessage(exc.getMessage());
		err.setPath(requi.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(RecursoNaoInformado.class)
	public ResponseEntity<StandardError> entidadeNaoInformada(RecursoNaoInformado exc, HttpServletRequest requi) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Recurso não Informado.");
		err.setMessage(exc.getMessage());
		err.setPath(requi.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
