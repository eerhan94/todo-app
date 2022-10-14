package com.karaaslan.todoapp.model;

import lombok.Builder;
import lombok.Data;

/** The type Todo response dto. */
@Builder
@Data
public class TodoResponseDto {
  private String id;
  private String name;
  private String description;
  private Boolean status;
  private String username;
}
