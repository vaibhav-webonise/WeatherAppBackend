package com.webonise.weatherapp.model;

public class ResponseData {
  private String message;

  public ResponseData(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
