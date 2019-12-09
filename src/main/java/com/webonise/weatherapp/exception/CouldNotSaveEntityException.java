package com.webonise.weatherapp.exception;

public class CouldNotSaveEntityException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  public CouldNotSaveEntityException(String message) {
    super(message);
  }
}
