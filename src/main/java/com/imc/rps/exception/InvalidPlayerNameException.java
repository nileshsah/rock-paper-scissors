package com.imc.rps.exception;

public class InvalidPlayerNameException extends RuntimeException {

  public InvalidPlayerNameException(String message) {
    super(message);
  }
}
