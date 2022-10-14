package com.karaaslan.todoapp.service;

import com.karaaslan.todoapp.entity.TodoItem;
import com.karaaslan.todoapp.exception.GlobalApiException;
import com.karaaslan.todoapp.mapper.TodoDTOMapper;
import com.karaaslan.todoapp.model.TodoItemCreateRequest;
import com.karaaslan.todoapp.model.TodoItemUpdateRequest;
import com.karaaslan.todoapp.model.TodoResponseDto;
import com.karaaslan.todoapp.repository.TodoRepository;
import com.karaaslan.todoapp.service.impl.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
  @InjectMocks private TodoServiceImpl todoService;

  @Mock TodoRepository todoRepository;
  @Mock TodoDTOMapper todoDTOMapper;
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private final String id = "id";
  private final String username = "username";
  private final String password = "password";
  private final String name = "password";
  private final String description = "description";
  private final Boolean status = true;

  @Test
  public void addTodo_shouldBeSuccess() {
    TodoItemCreateRequest todoItemCreateRequest = getTodoItemCreateRequest();
    TodoItem todoItem = getTodoItem();
    TodoResponseDto todoResponseDto = getTodoResponseDto();

    when(todoDTOMapper.toTodoItem(todoItemCreateRequest)).thenReturn(todoItem);
    when(todoRepository.save(any(TodoItem.class))).thenReturn(todoItem);
    when(todoDTOMapper.toTodoResponseDto(todoItem)).thenReturn(todoResponseDto);

    TodoResponseDto todoResponseDtoResult = todoService.addTodo(todoItemCreateRequest);
    Assert.assertEquals(todoItemCreateRequest.getName(), todoResponseDtoResult.getName());
    Assert.assertEquals(
        todoItemCreateRequest.getDescription(), todoResponseDtoResult.getDescription());
    Assert.assertEquals(todoItemCreateRequest.getStatus(), todoResponseDtoResult.getStatus());
    Assert.assertEquals(todoItemCreateRequest.getUsername(), todoResponseDtoResult.getUsername());
  }

  @Test
  public void getAllTodo_shouldBeSuccess() {
    TodoItem todoItem = getTodoItem();
    TodoResponseDto todoResponseDto = getTodoResponseDto();
    when(todoRepository.findAllByUsername(username)).thenReturn(Arrays.asList(todoItem));
    when(todoDTOMapper.toTodoResponseDto(todoItem)).thenReturn(todoResponseDto);

    List<TodoResponseDto> todoResponseDtoListResult = todoService.getAllTodo(username);
    Assert.assertEquals(1, todoResponseDtoListResult.size());

    TodoResponseDto todoResponseDtoResult = todoResponseDtoListResult.get(0);
    Assert.assertEquals(todoItem.getName(), todoResponseDtoResult.getName());
    Assert.assertEquals(todoItem.getDescription(), todoResponseDtoResult.getDescription());
    Assert.assertEquals(todoItem.getStatus(), todoResponseDtoResult.getStatus());
    Assert.assertEquals(todoItem.getUsername(), todoResponseDtoResult.getUsername());
  }

  @Test
  public void getTodo_shouldBeSuccess() {
    TodoItem todoItem = getTodoItem();
    TodoResponseDto todoResponseDto = getTodoResponseDto();

    when(todoRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(todoItem));
    when(todoDTOMapper.toTodoResponseDto(todoItem)).thenReturn(todoResponseDto);

    TodoResponseDto todoResponseDtoResult = todoService.getTodo(id);

    Assert.assertEquals(todoItem.getName(), todoResponseDtoResult.getName());
    Assert.assertEquals(todoItem.getDescription(), todoResponseDtoResult.getDescription());
    Assert.assertEquals(todoItem.getStatus(), todoResponseDtoResult.getStatus());
    Assert.assertEquals(todoItem.getUsername(), todoResponseDtoResult.getUsername());
  }

  @Test
  public void deleteTodo_shouldBeSuccess() {
    TodoItem todoItem = getTodoItem();

    when(todoRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(todoItem));

    todoService.deleteTodo(id);
  }

  @Test
  public void updateTodo_shouldBeSuccess() {
    TodoItem todoItem = getTodoItem();
    TodoItemUpdateRequest todoItemUpdateRequest = getTodoItemUpdateRequest();
    TodoResponseDto todoResponseDto = getTodoResponseDto();

    when(todoRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(todoItem));
    when(todoRepository.save(any(TodoItem.class))).thenReturn(todoItem);
    when(todoDTOMapper.toTodoResponseDto(todoItem)).thenReturn(todoResponseDto);

    TodoResponseDto todoResponseDtoResult = todoService.updateTodo(id, todoItemUpdateRequest);
    Assert.assertEquals(todoItemUpdateRequest.getName(), todoResponseDtoResult.getName());
    Assert.assertEquals(
        todoItemUpdateRequest.getDescription(), todoResponseDtoResult.getDescription());
    Assert.assertEquals(todoItemUpdateRequest.getStatus(), todoResponseDtoResult.getStatus());
    Assert.assertEquals(todoItemUpdateRequest.getUsername(), todoResponseDtoResult.getUsername());
  }

  @Test
  public void todoFindById_shouldBeError_userNotFound() {
    expectedException.expect(GlobalApiException.class);

    TodoItemUpdateRequest todoItemUpdateRequest = getTodoItemUpdateRequest();

    when(todoRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

    todoService.updateTodo(id, todoItemUpdateRequest);
  }

  private TodoItem getTodoItem() {
    return TodoItem.builder()
        .name(name)
        .description(description)
        .status(status)
        .username(username)
        .build();
  }

  private TodoItemCreateRequest getTodoItemCreateRequest() {
    TodoItemCreateRequest todoItemCreateRequest =
        TodoItemCreateRequest.builder()
            .name(name)
            .description(description)
            .status(status)
            .username(username)
            .build();
    return todoItemCreateRequest;
  }

  private TodoItemUpdateRequest getTodoItemUpdateRequest() {
    TodoItemUpdateRequest todoItemUpdateRequest =
        TodoItemUpdateRequest.builder()
            .name(name)
            .description(description)
            .status(status)
            .username(username)
            .build();
    return todoItemUpdateRequest;
  }

  private TodoResponseDto getTodoResponseDto() {
    return TodoResponseDto.builder()
        .name(name)
        .description(description)
        .status(status)
        .username(username)
        .build();
  }
}
