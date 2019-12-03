package com.webonise.weatherapp.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.webonise.weatherapp.dao.CityRepository;
import com.webonise.weatherapp.dao.UserRepository;
import com.webonise.weatherapp.exception.NoCitiesAvailableException;
import com.webonise.weatherapp.exception.ResourceNotFoundException;
import com.webonise.weatherapp.exception.UserNotAvailableException;
import com.webonise.weatherapp.model.City;
import com.webonise.weatherapp.model.UserData;
import com.webonise.weatherapp.service.CityService;

@Service
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository cityRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  @Value("${city.page.size}")
  private int pageSize;

  @Override
  public List<City> getCitiesByUsername(String username, int pageNo) {
    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("createdAt").descending());
    Optional<UserData> userData = Optional.ofNullable(userRepository.findByUsername(username));
    if (userData.isPresent()) {
      Page<City> cityList = cityRepository.findByUserDataId(userData.get().getId(), pageable);
      if (!cityList.isEmpty()) {
        return cityList.getContent();
      } else {
        throw new NoCitiesAvailableException("No cities available for given username");
      }
    } else {
      throw new UserNotAvailableException("User not available");
    }
  }

  @Override
  public City addCity(String username, City city) {
    Optional<UserData> userData = Optional.ofNullable(userRepository.findByUsername(username));
    if (userData.isPresent()) {
      return (userRepository.findById(userData.get().getId())).map(user -> {
        city.setUserData(user);
        return cityRepository.save(city);
      }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userData.get().getId()));
    } else {
      throw new UserNotAvailableException("No user available with given username");
    }
  }
}
