package com.karaaslan.todoapp.repository;

import com.karaaslan.todoapp.entity.TodoItem;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** The interface Todo repository. */
@Repository
public interface TodoRepository extends CouchbaseRepository<TodoItem, String> {
  /**
   * Find all by username list.
   *
   * @param username the username
   * @return the list
   */
  List<TodoItem> findAllByUsername(String username);
}
