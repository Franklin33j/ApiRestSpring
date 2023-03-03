package com.example.demo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component

public class JwtTokenProvider {
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpiration;
	public String generateToken(Authentication authentication)
	{
		String username= authentication.getName();
		Date dateNow=  new Date();
		Date expirationDate= new Date(dateNow.getTime()+jwtExpiration);
		
		String token = Jwts.builder().setSubject(username).setIssuedAt(new  Date()).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
		return  token;
	}
	public String GetUsernameByToken(String token)
	{
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
	public boolean TokenValidated(String token)
	{
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
			
		}
		catch (SignatureException ex) {
			throw new com.example.demo.exceptions.JwtException("Firma del Token no valida", HttpStatus.BAD_REQUEST);
		}
		catch (MalformedJwtException ex) {
			throw new com.example.demo.exceptions.JwtException("Token no valido", HttpStatus.BAD_REQUEST);
		}
		catch (ExpiredJwtException ex) {
			throw new com.example.demo.exceptions.JwtException("Token caducado", HttpStatus.BAD_REQUEST);
		}
		catch (UnsupportedJwtException ex) {
			throw new com.example.demo.exceptions.JwtException("Firma del Token no compartible", HttpStatus.BAD_REQUEST);
		}
		catch (IllegalArgumentException ex) {
			throw new com.example.demo.exceptions.JwtException("El claim del token se encuentra vacio", HttpStatus.BAD_REQUEST);
		}
	}
}
