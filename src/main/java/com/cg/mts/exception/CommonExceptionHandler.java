package com.cg.mts.exception;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.dto.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler
	 public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidUserException e)
	 {
	  ExceptionDTOResponse dto = new ExceptionDTOResponse();
	  dto.setErrorMsg(e.toString());
	  dto.setDatetime(LocalDateTime.now()+"");
	  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	 }
	              
	 @ExceptionHandler
	 public ResponseEntity<ExceptionDTOResponse> invalidPassword(NullPointerException e)
	 {
	  ExceptionDTOResponse dto = new ExceptionDTOResponse();
	  dto.setErrorMsg(e.toString());
	  dto.setDatetime(LocalDateTime.now()+"");
	  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	 }
	 @ExceptionHandler
	 public ResponseEntity<ExceptionDTOResponse> invalidEntity(EntityNotFoundException e)
	 {
		 ExceptionDTOResponse dto = new ExceptionDTOResponse();
		 dto.setErrorMsg(e.getMessage());
		 dto.setDatetime(LocalDateTime.now()+"");
		 return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	 }
}
