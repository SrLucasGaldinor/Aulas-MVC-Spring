package com.example.aula.exceptions;

public class RecursoJaCadastrado extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecursoJaCadastrado(String msg) {
		super(msg);
	}
}
