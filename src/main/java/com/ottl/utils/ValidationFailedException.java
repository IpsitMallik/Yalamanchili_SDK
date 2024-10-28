package com.ottl.utils;

/**
 * Custom exception for Validation errors.
 */
public class ValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationFailedException(String message) {
		super(message);
	}
}
