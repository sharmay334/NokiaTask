package com.nokia.nokiamain.exception;

import lombok.Getter;

@Getter
public class NokiaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NokiaException(String message) {
		super(message);
	}
}
