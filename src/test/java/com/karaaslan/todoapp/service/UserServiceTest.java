package com.karaaslan.todoapp.service;

import com.karaaslan.todoapp.entity.User;
import com.karaaslan.todoapp.mapper.UserDTOMapper;
import com.karaaslan.todoapp.model.UserCreateRequest;
import com.karaaslan.todoapp.model.UserResponseDto;
import com.karaaslan.todoapp.repository.UserRepository;
import com.karaaslan.todoapp.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  @InjectMocks private UserServiceImpl userService;

  @Mock UserRepository userRepository;
  @Mock UserDTOMapper userDTOMapper;

  private final String username = "username";
  private final String password = "password";

  @Test
  public void createUser_shouldBeSuccess() {
    UserCreateRequest userCreateRequest =
        UserCreateRequest.builder().username(username).password(password).build();
    User user = User.builder().username(username).password(password).build();
    UserResponseDto userResponseDto =
        UserResponseDto.builder().username(username).password(password).build();

    when(userDTOMapper.toUser(any(UserCreateRequest.class))).thenReturn(user);
    when(userRepository.save(any(User.class))).thenReturn(user);
    when(userDTOMapper.toUserResponseDto(any(User.class))).thenReturn(userResponseDto);

    UserResponseDto userResponseDtoResult = userService.creteUser(userCreateRequest);
    Assert.assertEquals(userCreateRequest.getUsername(), userResponseDtoResult.getUsername());
    Assert.assertEquals(userCreateRequest.getPassword(), userResponseDtoResult.getPassword());
  }

  @Test
  public void findByUsername_shouldBeSuccess() {
    User user = User.builder().username(username).password(password).build();

    when(userRepository.findByUsername(username)).thenReturn(user);

    User userResult = userService.findByUsername(username);
    Assert.assertEquals(user.getUsername(), userResult.getUsername());
    Assert.assertEquals(user.getPassword(), userResult.getPassword());
  }
}
