package com.narada.sdk.utilities;

/**
 * Custom exception for Validation errors.
 */
public class ValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationFailedException(String message) {
		super(message);
	}
}
