package com.sujeet.TMApplication.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sujeet.TMApplication.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorController {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleExceptionForTourist(TouristNotFoundException t) {
		ErrorDetails error = new ErrorDetails("404 Not Found", t.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleExceptionTourist(Exception e) {
		ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
}
