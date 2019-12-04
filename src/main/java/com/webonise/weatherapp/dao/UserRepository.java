package com.webonise.weatherapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webonise.weatherapp.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

  Boolean existsByUsername(String username);
  UserData findByUsername(String username);
}
