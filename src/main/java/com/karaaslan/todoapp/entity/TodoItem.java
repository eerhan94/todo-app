package com.karaaslan.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.validation.constraints.NotNull;

/** The type Todo item. */
@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
  @NotNull @Id private String id;
  @NotNull @Field private String name;
  @NotNull @Field private String description;
  @NotNull @Field private Boolean status;
  @NotNull @Field private String username;
}
