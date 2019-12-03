package com.webonise.weatherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserAlreadyExistsException.class)
  public ResponseEntity<Object> exception(UserAlreadyExistsException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = NoUsersAvailableOnRequestedPageNo.class)
  public ResponseEntity<Object> exception(NoUsersAvailableOnRequestedPageNo exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserNotAvailableException.class)
  public ResponseEntity<Object> exception(UserNotAvailableException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = NoCitiesAvailableException.class)
  public ResponseEntity<Object> exception(NoCitiesAvailableException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(value = CityAlreadyExistsException.class)
  public ResponseEntity<Object> exception(CityAlreadyExistsException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }
}
