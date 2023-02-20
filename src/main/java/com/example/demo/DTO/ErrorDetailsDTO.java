package com.example.demo.DTO;

import java.util.Date;

public class ErrorDetailsDTO {

	private Date date;
	private String message;
	private String description;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ErrorDetailsDTO(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}
	public ErrorDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}