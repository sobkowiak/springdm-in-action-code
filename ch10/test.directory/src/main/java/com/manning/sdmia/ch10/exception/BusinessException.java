/**
 * 
 */
package com.manning.sdmia.ch10.exception;

/**
 * @author acogoluegnes
 *
 */
public class BusinessException extends Exception {

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
