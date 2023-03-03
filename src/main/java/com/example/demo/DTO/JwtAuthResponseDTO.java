package com.example.demo.DTO;

public class JwtAuthResponseDTO {

	private String accessToken;
	private String typeToken="Bearer";
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTypeToken() {
		return typeToken;
	}
	public JwtAuthResponseDTO(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	
	
}
