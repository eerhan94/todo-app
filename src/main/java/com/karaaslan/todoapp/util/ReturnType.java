package com.karaaslan.todoapp.util;

/** The enum Return type. */
public enum ReturnType {
  /** The Success. */
  SUCCESS(0, "The operation succeeded."),
  /** The Failure. */
  FAILURE(-1, "An error occurred");

  /** The Code. */
  int code;

  /** The Message. */
  String message;

  ReturnType(int code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public int getCode() {
    return this.code;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return this.message;
  }
}
