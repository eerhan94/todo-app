package com.karaaslan.todoapp.service;

import com.karaaslan.todoapp.entity.User;
import com.karaaslan.todoapp.model.UserCreateRequest;
import com.karaaslan.todoapp.model.UserResponseDto;

/** The interface User service. */
public interface UserService {
  /**
   * Crete user user response dto.
   *
   * @param userCreateRequest the user create request
   * @return the user response dto
   */
  UserResponseDto creteUser(UserCreateRequest userCreateRequest);

  /**
   * Find by username user.
   *
   * @param username the username
   * @return the user
   */
  User findByUsername(String username);
}
