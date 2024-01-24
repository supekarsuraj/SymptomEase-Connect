package com.qsp.Lattice.Assignment.Exception;

public class PetientNotFound extends RuntimeException{

	private String message;
	
	public PetientNotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
