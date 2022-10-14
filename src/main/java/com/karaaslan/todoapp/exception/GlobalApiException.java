package com.karaaslan.todoapp.exception;

/** The type Global api exception. */
public class GlobalApiException extends RuntimeException {

  private final int code;
  private final String message;

  /**
   * Instantiates a new Global api exception.
   *
   * @param errorCode the error code
   */
  public GlobalApiException(ErrorCodes errorCode) {
    super();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
