package com.webonise.weatherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<String> exception(ResourceNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserAlreadyExistsException.class)
  public ResponseEntity<String> exception(UserAlreadyExistsException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = NoUsersAvailableOnRequestedPageNo.class)
  public ResponseEntity<String> exception(NoUsersAvailableOnRequestedPageNo exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserNotAvailableException.class)
  public ResponseEntity<String> exception(UserNotAvailableException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = NoCitiesAvailableException.class)
  public ResponseEntity<String> exception(NoCitiesAvailableException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = CityAlreadyExistsException.class)
  public ResponseEntity<String> exception(CityAlreadyExistsException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = JwtTokenExpiredException.class)
  public ResponseEntity<String> exception(JwtTokenExpiredException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }
  
  @ExceptionHandler(value = CouldNotSaveEntityException.class)
  public ResponseEntity<String> exception(CouldNotSaveEntityException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
