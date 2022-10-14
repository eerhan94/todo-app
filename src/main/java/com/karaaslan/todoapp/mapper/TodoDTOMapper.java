package com.karaaslan.todoapp.mapper;

import com.karaaslan.todoapp.entity.TodoItem;
import com.karaaslan.todoapp.model.TodoItemCreateRequest;
import com.karaaslan.todoapp.model.TodoResponseDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/** The type Todo dto mapper. */
@Service
public class TodoDTOMapper {
  /**
   * To todo item todo item.
   *
   * @param todoItemCreateRequest the todo item create request
   * @return the todo item
   */
  public TodoItem toTodoItem(TodoItemCreateRequest todoItemCreateRequest) {
    return TodoItem.builder()
        .id(UUID.randomUUID().toString())
        .name(todoItemCreateRequest.getName())
        .description(todoItemCreateRequest.getDescription())
        .status(todoItemCreateRequest.getStatus())
        .username(todoItemCreateRequest.getUsername())
        .build();
  }

  /**
   * To todo response dto todo response dto.
   *
   * @param todoItem the todo item
   * @return the todo response dto
   */
  public TodoResponseDto toTodoResponseDto(TodoItem todoItem) {
    return TodoResponseDto.builder()
        .id(todoItem.getId())
        .name(todoItem.getName())
        .description(todoItem.getDescription())
        .status(todoItem.getStatus())
        .username(todoItem.getUsername())
        .build();
  }
}
