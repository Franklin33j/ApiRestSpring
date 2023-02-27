package com.example.demo.exceptions;

public class ConstraintException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ConstraintException(String message) {
		super(message);
		this.message = message;
	} 
	

}
