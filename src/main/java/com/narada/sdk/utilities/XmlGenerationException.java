package com.narada.sdk.utilities;

/**
 * Custom exception for XML generation errors.
 */
public class XmlGenerationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public XmlGenerationException(String message) {
		super(message);
	}

	public XmlGenerationException(String message, Throwable cause) {
		super(message, cause);
	}
}
