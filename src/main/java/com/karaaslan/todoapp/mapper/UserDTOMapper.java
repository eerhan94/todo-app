package com.karaaslan.todoapp.mapper;

import com.karaaslan.todoapp.entity.User;
import com.karaaslan.todoapp.model.UserCreateRequest;
import com.karaaslan.todoapp.model.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/** The type User dto mapper. */
@Service
public class UserDTOMapper {
  /**
   * To user user.
   *
   * @param userCreateRequest the user create request
   * @return the user
   */
  public User toUser(UserCreateRequest userCreateRequest) {
    return User.builder()
        .id(UUID.randomUUID().toString())
        .username(userCreateRequest.getUsername())
        .password(userCreateRequest.getPassword())
        .build();
  }

  /**
   * To user response dto user response dto.
   *
   * @param user the user
   * @return the user response dto
   */
  public UserResponseDto toUserResponseDto(User user) {
    return UserResponseDto.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .build();
  }
}
