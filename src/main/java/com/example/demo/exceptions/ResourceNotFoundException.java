package com.example.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String column;
	private String value;
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ResourceNotFoundException(String column, String value) {
		super(String.format("No se ha encontrado un registro para: %s con el valor de: %s",column,value ));
		this.column = column;
		this.value = value;
	}

}
