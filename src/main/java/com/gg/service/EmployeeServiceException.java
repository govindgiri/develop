package com.gg.service;

public class EmployeeServiceException extends Exception {

	private static final long serialVersionUID = 9058127854580181199L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}
}