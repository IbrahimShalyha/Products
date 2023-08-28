package com.products.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.products.customexception.BrandNotFoundException;
import com.products.customexception.IdNotFoundException;
import com.products.customexception.NameNotFoundException;

@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandle() {
		return new ResponseEntity<Object>("BRAND DOES NOT EXIST", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameHandle() {
		return new ResponseEntity<Object>("NAME DOES NOT EXIST", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idHandle() {
		return new ResponseEntity<Object>("ID DOES NOT EXIST", HttpStatus.BAD_REQUEST);
	}

}
