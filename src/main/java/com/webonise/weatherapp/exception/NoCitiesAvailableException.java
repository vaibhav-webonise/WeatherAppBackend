package com.webonise.weatherapp.exception;

public class NoCitiesAvailableException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public NoCitiesAvailableException(String message) {
    super(message);
  }
}
