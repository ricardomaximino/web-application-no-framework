package com.brasajava.exceptions;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6897515830967299065L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
