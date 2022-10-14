package com.karaaslan.todoapp.exception;

/** The enum Error codes. */
public enum ErrorCodes {
  /** The Todo not found. */
  TODO_NOT_FOUND(1001, "Todo record not found"),
  /** The User not found. */
  USER_NOT_FOUND(2001, "User not found"),
  /** The Incorrect or password. */
  INCORRECT_OR_PASSWORD(2001, "Incorrect username or password");

  private final int code;
  private final String message;

  ErrorCodes(int code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}
