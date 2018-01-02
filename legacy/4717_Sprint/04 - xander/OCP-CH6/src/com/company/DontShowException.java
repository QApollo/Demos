package com.company;

public class DontShowException extends Exception {
  public DontShowException() {

  }

  public DontShowException(Exception e) {
    super(e);
  }

  public DontShowException(String message) {
    super(message);
  }
}
