package com.webonise.weatherapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webonise.weatherapp.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

  public Boolean existsByUsername(String username);
  public UserData findByUsername(String username);
}
