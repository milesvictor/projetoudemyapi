/*
		Classe de exceção personalizada que é disparada quando for buscado um id inexistente .
*/

package com.victor.projeto_afrodev.services.exception;


public class ObjectNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	
	public ObjectNotFoundException(String msg) {
		
		super(msg);
	}
	
}
