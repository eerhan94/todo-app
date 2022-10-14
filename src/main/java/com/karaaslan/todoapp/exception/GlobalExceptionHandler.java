package com.karaaslan.todoapp.exception;

import com.karaaslan.todoapp.util.ResponseBuilder;
import com.karaaslan.todoapp.util.ReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

/** The type Global exception handler. */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Handle exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(value = Exception.class)
  public final ResponseEntity<Map<String, Object>> handleException(Exception ex) {
    ex.printStackTrace();
    return new ResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR, ReturnType.FAILURE)
        .withError(ex)
        .build();
  }

  /**
   * Handle invalid link exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(value = GlobalApiException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidLinkException(GlobalApiException ex) {
    ex.printStackTrace();
    return new ResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR, ReturnType.FAILURE)
        .withError(ex)
        .build();
  }
}
