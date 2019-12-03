package com.webonise.weatherapp.exception;

public class NoUsersAvailableOnRequestedPageNo extends RuntimeException {

  private static final long serialVersionUID = 1L;
  public NoUsersAvailableOnRequestedPageNo(String message) {
    super(message);
  }
}
