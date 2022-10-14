package com.karaaslan.todoapp.controller;

import com.karaaslan.todoapp.model.TodoItemCreateRequest;
import com.karaaslan.todoapp.model.TodoItemUpdateRequest;
import com.karaaslan.todoapp.service.TodoService;
import com.karaaslan.todoapp.util.ResponseBuilder;
import com.karaaslan.todoapp.util.ResponseDataKey;
import com.karaaslan.todoapp.util.ReturnType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

/** The type Todo controller. */
@RestController
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  /**
   * Add todo response entity.
   *
   * @param todoItemCreateRequest the todo item create request
   * @return the response entity
   */
  @PostMapping("/todo")
  public ResponseEntity<Map<String, Object>> addTodo(
      @RequestBody TodoItemCreateRequest todoItemCreateRequest) {
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.CONTENT, todoService.addTodo(todoItemCreateRequest))
        .build();
  }

  /**
   * Gets all todo.
   *
   * @param username the username
   * @return the all todo
   */
  @GetMapping("/todo/all")
  public ResponseEntity<Map<String, Object>> getAllTodo(@PathParam("username") String username) {
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.CONTENT, todoService.getAllTodo(username))
        .build();
  }

  /**
   * Gets todo.
   *
   * @param id the id
   * @return the todo
   */
  @GetMapping("/todo/{id}")
  public ResponseEntity<Map<String, Object>> getTodo(@PathVariable String id) {
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.CONTENT, todoService.getTodo(id))
        .build();
  }

  /**
   * Delete todo response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping("/todo/{id}")
  public ResponseEntity<Map<String, Object>> deleteTodo(@PathVariable String id) {
    todoService.deleteTodo(id);
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.MESSAGE, "Successfully deleted")
        .build();
  }

  /**
   * Update todo response entity.
   *
   * @param id the id
   * @param todoItemUpdateRequest the todo item update request
   * @return the response entity
   */
  @PutMapping("/todo/{id}")
  public ResponseEntity<Map<String, Object>> updateTodo(
      @PathVariable String id, @RequestBody TodoItemUpdateRequest todoItemUpdateRequest) {
    return new ResponseBuilder(HttpStatus.OK, ReturnType.SUCCESS)
        .withData(ResponseDataKey.CONTENT, todoService.updateTodo(id, todoItemUpdateRequest))
        .build();
  }
}
