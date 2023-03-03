package com.example.demo.exceptions;

public class IncorrectCredentialsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectCredentialsException() {
		super("El nombre de usuario o la contraceña son incorrectas");
		// TODO Auto-generated constructor stub
	}


	

}
