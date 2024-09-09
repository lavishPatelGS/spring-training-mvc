package org.groupsoft.training.spring_training_mvc.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

public class DatabaseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8096080983493703083L;

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public static void handleSQLException(Exception ex, String contextMessage) {
		Throwable cause = ex.getCause();
		if (cause instanceof org.hibernate.exception.ConstraintViolationException) {
			org.hibernate.exception.ConstraintViolationException constraintException = (org.hibernate.exception.ConstraintViolationException) cause;
			if ("23505".equals(constraintException.getSQLState()) || constraintException.getErrorCode() == 1062) {
				System.out.println("======handleSQLException====DuplicateKeyException");
				throw new DatabaseException("Database Duplicate Key Exception: " + ex.getMessage(), ex);
			}
			// Handle other SQL exceptions if needed
		}
		System.out.println("======handleSQLException====DatabaseException");
		throw new DatabaseException("Database error: " + ex.getMessage(), ex);
	}
}
