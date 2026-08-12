package com.amr.terra.exception;

public class UnsupportedVersionError extends TerrapperError {
  public UnsupportedVersionError() { super(); }
  public UnsupportedVersionError(Throwable cause) { super(cause); }
  public UnsupportedVersionError(String message) { super(message); }
  public UnsupportedVersionError(String message, Throwable cause) { super(message, cause); }
}
