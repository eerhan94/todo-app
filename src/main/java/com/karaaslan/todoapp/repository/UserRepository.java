package com.karaaslan.todoapp.repository;

import com.karaaslan.todoapp.entity.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/** The interface User repository. */
@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {
  /**
   * Find by username user.
   *
   * @param username the username
   * @return the user
   */
  User findByUsername(String username);
}
