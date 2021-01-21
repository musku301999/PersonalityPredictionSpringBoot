package com.boot.ppp.exception;

public class ResourceAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException() {
	}

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}

}
