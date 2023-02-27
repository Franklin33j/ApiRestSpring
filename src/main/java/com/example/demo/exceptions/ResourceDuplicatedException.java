package com.example.demo.exceptions;

public class ResourceDuplicatedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String column;
	private String value;
	public ResourceDuplicatedException(String column, String value) {
		super(String.format("Ya existe un registro para: %s con el valor de: %s", column,value));
		this.column = column;
		this.value = value;
	}
	
	
}
