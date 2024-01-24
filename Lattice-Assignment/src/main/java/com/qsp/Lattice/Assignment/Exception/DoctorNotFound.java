package com.qsp.Lattice.Assignment.Exception;

public class DoctorNotFound extends RuntimeException{

	private String message;
	
	public DoctorNotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

