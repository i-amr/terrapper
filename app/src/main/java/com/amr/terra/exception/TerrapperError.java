package com.amr.terra.exception;

public class TerrapperError extends Exception {
  public TerrapperError() { super(); }
  public TerrapperError(Throwable cause) { super(cause); }
  public TerrapperError(String message) { super(message); }
  public TerrapperError(String message, Throwable cause) { super(message, cause); }
}
