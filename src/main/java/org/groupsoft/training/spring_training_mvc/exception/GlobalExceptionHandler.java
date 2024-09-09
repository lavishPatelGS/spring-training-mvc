package org.groupsoft.training.spring_training_mvc.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	// For Web (Redirect with Flash Attribute)
		@ExceptionHandler(DatabaseException.class)
		public String handleDatabaseException(Exception ex, HttpServletRequest request,
				RedirectAttributes redirectAttributes) {
			System.out.println("======DatabaseException====");
			logger.error("Web Exception caught: {}", ex.getMessage(), ex);
			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
			String referer = request.getHeader("Referer");
			return "redirect:" + referer;
		}
	
	// For Web (Redirect with Flash Attribute)
	@ExceptionHandler(Exception.class)
	public String handleGlobalExceptionForWeb(Exception ex, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		logger.error("Web Exception caught: {}", ex.getMessage(), ex);
		redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
