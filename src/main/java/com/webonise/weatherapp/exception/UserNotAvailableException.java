package com.webonise.weatherapp.exception;

public class UserNotAvailableException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  public UserNotAvailableException(String message) {
    super(message);
  }
}
