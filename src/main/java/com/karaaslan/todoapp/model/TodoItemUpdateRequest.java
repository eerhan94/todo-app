package com.karaaslan.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** The type Todo item update request. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemUpdateRequest {
  private String name;
  private String description;
  private Boolean status;
  @NotNull private String username;
}
