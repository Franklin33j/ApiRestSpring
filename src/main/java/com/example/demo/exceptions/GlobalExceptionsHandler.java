package com.example.demo.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.DTO.ErrorDetailsDTO;

@ControllerAdvice
public class GlobalExceptionsHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	 public ResponseEntity<ErrorDetailsDTO> ErrorsDetailsExceptions(Exception exception,WebRequest request) 
	 {
		ErrorDetailsDTO errors= new ErrorDetailsDTO(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetailsDTO>(errors,HttpStatus.CONFLICT);
	 }

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String nameField=  ((FieldError)error).getField();
			String errorMessage= error.getDefaultMessage();
			errors.put(nameField, errorMessage);
		});
		
		return new ResponseEntity<Object>(errors, HttpStatus.CONFLICT);
	}
	 @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	        String message = "";
	        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	    }
	 
	    @ExceptionHandler(IncorrectCredentialsException.class)
	    public ResponseEntity<ErrorDetailsDTO> manejarExcepcion(IncorrectCredentialsException ex,WebRequest request) {
	        // crea un objeto de respuesta con el mensaje de error
	    	ErrorDetailsDTO errors= new ErrorDetailsDTO(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<ErrorDetailsDTO>(errors,HttpStatus.UNAUTHORIZED);
	    }
	 
}
