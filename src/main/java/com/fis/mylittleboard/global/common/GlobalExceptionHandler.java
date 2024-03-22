package com.fis.mylittleboard.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<RestApiException> handleIllegalArgumentException(
      IllegalArgumentException ex) {
    RestApiException restApiException = new RestApiException(ex.getMessage(),
        HttpStatus.BAD_REQUEST.value());
    return new ResponseEntity<>(
        restApiException,
        HttpStatus.BAD_REQUEST
    );
  }

}
