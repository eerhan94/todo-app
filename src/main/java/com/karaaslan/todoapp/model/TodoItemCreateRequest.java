package com.karaaslan.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** The type Todo item create request. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemCreateRequest {
  @NotNull private String name;
  @NotNull private String description;
  @NotNull private Boolean status;
  @NotNull private String username;
}
