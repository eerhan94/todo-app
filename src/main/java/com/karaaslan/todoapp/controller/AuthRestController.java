package com.karaaslan.todoapp.controller;

import com.karaaslan.todoapp.exception.ErrorCodes;
import com.karaaslan.todoapp.exception.GlobalApiException;
import com.karaaslan.todoapp.model.AuthRequest;
import com.karaaslan.todoapp.service.CustomUserDetailsService;
import com.karaaslan.todoapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** The type Auth rest controller. */
@RestController
@RequiredArgsConstructor
public class AuthRestController {

  private final JwtUtil jwtUtil;

  private final AuthenticationManager authenticationManager;

  private final CustomUserDetailsService userDetailsService;

  /**
   * Crete token string.
   *
   * @param authRequest the auth request
   * @return the string
   */
  @PostMapping("/login")
  public String creteToken(@RequestBody AuthRequest authRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authRequest.getUsername(), authRequest.getPassword()));
    } catch (BadCredentialsException ex) {
      throw new GlobalApiException(ErrorCodes.INCORRECT_OR_PASSWORD);
    }
    final UserDetails userDetails =
        userDetailsService.loadUserByUsername(authRequest.getUsername());
    return jwtUtil.generateToken(userDetails);
  }
}
