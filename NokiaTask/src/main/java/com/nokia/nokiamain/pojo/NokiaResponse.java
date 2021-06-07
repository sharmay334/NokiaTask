package com.nokia.nokiamain.pojo;

import lombok.Data;

@Data
public class NokiaResponse {
	private String message;

	public NokiaResponse(String message) {
		this.message = message;
	}

}
