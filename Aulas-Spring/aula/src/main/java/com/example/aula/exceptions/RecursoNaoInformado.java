package com.example.aula.exceptions;

public class RecursoNaoInformado extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecursoNaoInformado(String msg) {
		super(msg);
	}
}
