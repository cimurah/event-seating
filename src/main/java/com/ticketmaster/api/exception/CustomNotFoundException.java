package com.ticketmaster.api.exception;

public class CustomNotFoundException extends RuntimeException {

	public CustomNotFoundException(String msg) {
		super(msg);
	}
}
