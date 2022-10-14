package com.karaaslan.todoapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/** The type Response builder. */
public class ResponseBuilder {
  private final HttpStatus resultStatus;
  private final Map<String, Object> result = new HashMap();

  /**
   * Instantiates a new Response builder.
   *
   * @param resultStatus the result status
   * @param returnType the return type
   */
  public ResponseBuilder(final HttpStatus resultStatus, final ReturnType returnType) {
    this.resultStatus = resultStatus;
    this.result.put("returnCode", returnType.getCode());
    this.result.put("returnMessage", returnType.getMessage());
  }

  /**
   * With error response builder.
   *
   * @param e the e
   * @return the response builder
   */
  public ResponseBuilder withError(final Exception e) {
    this.result.put(ResponseDataKey.ERROR.getKey(), e.getMessage());
    return this;
  }

  /**
   * With data response builder.
   *
   * @param key the key
   * @param o the o
   * @return the response builder
   */
  public ResponseBuilder withData(final ResponseDataKey key, final Object o) {
    this.result.put(key.getKey(), o);
    return this;
  }

  /**
   * Build response entity.
   *
   * @return the response entity
   */
  public ResponseEntity<Map<String, Object>> build() {
    return new ResponseEntity(this.result, this.resultStatus);
  }
}
