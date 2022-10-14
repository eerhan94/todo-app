package com.karaaslan.todoapp.service;

import com.karaaslan.todoapp.entity.User;
import com.karaaslan.todoapp.exception.ErrorCodes;
import com.karaaslan.todoapp.exception.GlobalApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

/** The type Custom user details service. */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByUsername(username);
    if (Objects.isNull(user)) throw new GlobalApiException(ErrorCodes.USER_NOT_FOUND);

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), new ArrayList<>());
  }
}
