package com.karaaslan.todoapp.service;

import com.karaaslan.todoapp.model.TodoItemCreateRequest;
import com.karaaslan.todoapp.model.TodoItemUpdateRequest;
import com.karaaslan.todoapp.model.TodoResponseDto;

import java.util.List;

/** The interface Todo service. */
public interface TodoService {
  /**
   * Add todo todo response dto.
   *
   * @param todoItemCreateRequest the todo item create request
   * @return the todo response dto
   */
  TodoResponseDto addTodo(TodoItemCreateRequest todoItemCreateRequest);

  /**
   * Gets all todo.
   *
   * @param username the username
   * @return the all todo
   */
  List<TodoResponseDto> getAllTodo(String username);

  /**
   * Gets todo.
   *
   * @param id the id
   * @return the todo
   */
  TodoResponseDto getTodo(String id);

  /**
   * Delete todo.
   *
   * @param id the id
   */
  void deleteTodo(String id);

  /**
   * Update todo todo response dto.
   *
   * @param id the id
   * @param todoItemUpdateRequest the todo item update request
   * @return the todo response dto
   */
  TodoResponseDto updateTodo(String id, TodoItemUpdateRequest todoItemUpdateRequest);
}
