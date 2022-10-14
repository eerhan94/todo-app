package com.karaaslan.todoapp.service.impl;

import com.karaaslan.todoapp.entity.TodoItem;
import com.karaaslan.todoapp.exception.ErrorCodes;
import com.karaaslan.todoapp.exception.GlobalApiException;
import com.karaaslan.todoapp.mapper.TodoDTOMapper;
import com.karaaslan.todoapp.model.TodoItemCreateRequest;
import com.karaaslan.todoapp.model.TodoItemUpdateRequest;
import com.karaaslan.todoapp.model.TodoResponseDto;
import com.karaaslan.todoapp.repository.TodoRepository;
import com.karaaslan.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/** The type Todo service. */
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
  private final TodoRepository todoRepository;
  private final TodoDTOMapper todoDTOMapper;

  @Override
  public TodoResponseDto addTodo(TodoItemCreateRequest todoItemCreateRequest) {
    return todoDTOMapper.toTodoResponseDto(
        todoSaveAndUpdate(todoDTOMapper.toTodoItem(todoItemCreateRequest)));
  }

  @Override
  public List<TodoResponseDto> getAllTodo(String username) {
    List<TodoItem> todoItemList = todoRepository.findAllByUsername(username);
    return todoItemList.stream().map(todoDTOMapper::toTodoResponseDto).collect(Collectors.toList());
  }

  @Override
  public TodoResponseDto getTodo(String id) {
    return todoDTOMapper.toTodoResponseDto(todoFindById(id));
  }

  @Override
  public void deleteTodo(String id) {
    TodoItem todoItem = todoFindById(id);
    todoRepository.delete(todoItem);
  }

  @Override
  public TodoResponseDto updateTodo(String id, TodoItemUpdateRequest todoItemUpdateRequest) {
    TodoItem todoItem = todoFindById(id);
    todoItem.setName(
        !StringUtils.hasLength(todoItemUpdateRequest.getName())
            ? todoItem.getName()
            : todoItemUpdateRequest.getName());
    todoItem.setDescription(
        !StringUtils.hasLength(todoItemUpdateRequest.getDescription())
            ? todoItem.getDescription()
            : todoItemUpdateRequest.getDescription());
    todoItem.setStatus(
        !StringUtils.hasLength(todoItemUpdateRequest.getName())
            ? todoItem.getStatus()
            : todoItemUpdateRequest.getStatus());
    return todoDTOMapper.toTodoResponseDto(todoSaveAndUpdate(todoItem));
  }

  private TodoItem todoFindById(String id) {
    Optional<TodoItem> todoItemOptional = todoRepository.findById(id);
    if (todoItemOptional.isPresent()) return todoItemOptional.get();
    else throw new GlobalApiException(ErrorCodes.TODO_NOT_FOUND);
  }

  private TodoItem todoSaveAndUpdate(TodoItem todoItem) {
    return todoRepository.save(todoItem);
  }
}
