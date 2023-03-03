package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class JwtException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus estado;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getEstado() {
		return estado;
	}
	public void setEstado(HttpStatus estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JwtException(String message, HttpStatus estado) {
		super(message);
		this.message = message;
		this.estado = estado;
	}

}
