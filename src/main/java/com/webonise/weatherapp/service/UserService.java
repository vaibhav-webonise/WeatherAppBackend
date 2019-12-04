package com.webonise.weatherapp.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.webonise.weatherapp.model.AuthenticationResponse;
import com.webonise.weatherapp.model.UserData;

public interface UserService {
  /*
   * This service method will retrieve all the users available on the requested page
   * @Param pageNO
   * @Return user list
   */
  List<UserData> getUsers(int pageNo);

  /*
   * This service method will save the user details in the database
   * @Param userDetails object
   * @Return saved userDetails object
   */
  ResponseEntity<AuthenticationResponse> addUser(UserData userData);

}
