package com.karaaslan.todoapp.util;

/** The enum Response data key. */
public enum ResponseDataKey {
  /** Content response data key. */
  CONTENT("content"),
  /** Message response data key. */
  MESSAGE("message"),
  /** Error response data key. */
  ERROR("error");

  private final String key;

  ResponseDataKey(String key) {
    this.key = key;
  }

  /**
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return this.key;
  }
}
