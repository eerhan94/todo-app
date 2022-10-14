package com.karaaslan.todoapp.controller;

import com.karaaslan.todoapp.model.UserCreateRequest;
import com.karaaslan.todoapp.service.UserService;
import com.karaaslan.todoapp.util.ResponseBuilder;
import com.karaaslan.todoapp.util.ResponseDataKey;
import com.karaaslan.todoapp.util.ReturnType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/** The type User controller. */
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  /**
   * Add todo response entity.
   *
   * @param userCreateRequest the user create request
   * @return the response entity
   */
  @PostMapping("/user")
  public ResponseEntity<Map<String, Object>> addTodo(
      @RequestBody UserCreateRequest userCreateRequest) {
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.CONTENT, userService.creteUser(userCreateRequest))
        .build();
  }
}
