package com.karaaslan.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The type User response dto. */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
  private String username;
  private String password;
}
