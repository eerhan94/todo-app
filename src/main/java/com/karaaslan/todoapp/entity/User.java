package com.karaaslan.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.validation.constraints.NotNull;

/** The type User. */
@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @NotNull @Id private String id;
  @NotNull @Field private String username;
  @NotNull @Field private String password;
}
