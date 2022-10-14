package com.karaaslan.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** The type Auth request. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
  @NotNull private String username;
  @NotNull private String password;
}
