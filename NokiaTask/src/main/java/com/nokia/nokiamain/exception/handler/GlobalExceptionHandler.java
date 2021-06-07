package com.nokia.nokiamain.exception.handler;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nokia.nokiamain.exception.NokiaException;
import com.nokia.nokiamain.pojo.NokiaResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = { NokiaException.class })
	protected ResponseEntity<NokiaResponse> handleEMSException(NokiaException ex, WebRequest request) {
		ex.printStackTrace();
		return ResponseEntity.ok(new NokiaResponse(ex.getMessage()));
	}

	@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(new NokiaResponse("BAD_REQUEST"));
    }
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest().body(new NokiaResponse(ex.getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage).collect(Collectors.toList()).get(0)));
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<NokiaResponse> handleException(RuntimeException ex, WebRequest request) {
		ex.printStackTrace();
		return ResponseEntity.ok(new NokiaResponse("SOMETHING_WENT_WRONG"));
	}
	
}