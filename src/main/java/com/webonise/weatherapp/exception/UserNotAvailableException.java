package com.webonise.weatherapp.exception;

public class UserNotAvailableException extends RuntimeException {

  public UserNotAvailableException(String arg0, Throwable arg1) {
    super(arg0, arg1);
    // TODO Auto-generated constructor stub
  }
  private static final long serialVersionUID = 1L;
  public UserNotAvailableException(String message) {
    super(message);
  }
}
