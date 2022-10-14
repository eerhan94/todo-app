package com.karaaslan.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** The type User create request. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
  @NotNull private String username;
  @NotNull private String password;
}
