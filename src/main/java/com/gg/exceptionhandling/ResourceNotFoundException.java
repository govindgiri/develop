package com.gg.exceptionhandling;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -1904282652979066432L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}