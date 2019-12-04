package com.webonise.weatherapp.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.webonise.weatherapp.dao.UserRepository;
import com.webonise.weatherapp.exception.NoUsersAvailableOnRequestedPageNo;
import com.webonise.weatherapp.model.AuthenticationResponse;
import com.webonise.weatherapp.model.UserData;
import com.webonise.weatherapp.service.UserService;
import com.webonise.weatherapp.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

  @Value("${users.page.size}")
  private int pageSize;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private JwtUtil jwtUtil;
  private Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public List<UserData> getUsers(int pageNo) {
    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("createdAt").descending());
    Page<UserData> page = userRepository.findAll(pageable);
    if (page.hasContent()) {
      return page.getContent();
    } else {
      throw new NoUsersAvailableOnRequestedPageNo("No users are available for requested page number");
    }
  }

  @Override
  public ResponseEntity<AuthenticationResponse> addUser(UserData userData) {
    if (userRepository.existsByUsername(userData.getUsername())) {
      return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userData)));
    } else {
      UserData savedUser = userRepository.save(userData);
      log.info("Userdetails saved in the database:{}", savedUser.toString());
      return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(savedUser)));
    }
  }
}
