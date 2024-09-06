package org.groupsoft.training.spring_training_mvc.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundError(NoHandlerFoundException ex, Model model) {
		model.addAttribute("message", "The page you are looking for does not exist.");
		return "error/404";
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorDetails> handleCustomException(CustomException ex, WebRequest request) {
		logger.error("Exception caught: {}", ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
		logger.error("Exception caught: {}", ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request) {
		logger.error("Exception caught: {}", ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Database error occurred: " + ex.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

}
