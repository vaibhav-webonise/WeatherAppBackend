package com.webonise.weatherapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webonise.weatherapp.model.AuthenticationResponse;
import com.webonise.weatherapp.model.UserData;
import com.webonise.weatherapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{pageNo}")
  public List<UserData> getUsers(@PathVariable int pageNo) {
    return userService.getUsers(pageNo);
  }

  @PostMapping
  public ResponseEntity<AuthenticationResponse> saveUser(@RequestBody UserData userData) {
    return userService.addUser(userData);
  }
}
