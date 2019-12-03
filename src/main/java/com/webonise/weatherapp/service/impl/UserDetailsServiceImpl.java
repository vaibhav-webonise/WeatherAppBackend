package com.webonise.weatherapp.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.webonise.weatherapp.dao.UserRepository;
import com.webonise.weatherapp.exception.UserNotAvailableException;
import com.webonise.weatherapp.model.UserData;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<UserData> user = Optional.ofNullable(userRepository.findByUsername(username));
    if (user.isPresent()) {
      return new User(user.get().getUsername(), user.get().getUniqueId(), new ArrayList<>());
    } else {
      throw new UserNotAvailableException("Username not available");
    }
  }
}
