package com.karaaslan.todoapp.service.impl;

import com.karaaslan.todoapp.entity.User;
import com.karaaslan.todoapp.mapper.UserDTOMapper;
import com.karaaslan.todoapp.model.UserCreateRequest;
import com.karaaslan.todoapp.model.UserResponseDto;
import com.karaaslan.todoapp.repository.UserRepository;
import com.karaaslan.todoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** The type User service. */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserDTOMapper userDTOMapper;

  @Override
  public UserResponseDto creteUser(UserCreateRequest userCreateRequest) {
    return userDTOMapper.toUserResponseDto(
        userRepository.save(userDTOMapper.toUser(userCreateRequest)));
  }

  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
