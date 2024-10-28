package com.ottl.utils;

/**
 * Custom exception for Service errors.
 */
public class ServiceException extends RuntimeException {
	String code;
	private static final long serialVersionUID = 1L;

	public ServiceException(String code, String msg, Exception e) {
		super(msg, e);
		this.code = code;
	}

	public ServiceException(String code, String msg) {
		super(msg);
		this.code = code;
	}
}
