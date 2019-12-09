package com.webonise.weatherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.webonise.weatherapp.model.ResponseData;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<ResponseData> exception(ResourceNotFoundException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserAlreadyExistsException.class)
  public ResponseEntity<ResponseData> exception(UserAlreadyExistsException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = NoUsersAvailableOnRequestedPageNo.class)
  public ResponseEntity<ResponseData> exception(NoUsersAvailableOnRequestedPageNo exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = UserNotAvailableException.class)
  public ResponseEntity<ResponseData> exception(UserNotAvailableException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = NoCitiesAvailableException.class)
  public ResponseEntity<ResponseData> exception(NoCitiesAvailableException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = CityAlreadyExistsException.class)
  public ResponseEntity<ResponseData> exception(CityAlreadyExistsException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = JwtTokenExpiredException.class)
  public ResponseEntity<ResponseData> exception(JwtTokenExpiredException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(value = CouldNotSaveEntityException.class)
  public ResponseEntity<ResponseData> exception(CouldNotSaveEntityException exception) {
    return new ResponseEntity<>(new ResponseData(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
