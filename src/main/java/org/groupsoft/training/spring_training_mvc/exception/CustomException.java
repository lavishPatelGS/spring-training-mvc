package org.groupsoft.training.spring_training_mvc.exception;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
}
