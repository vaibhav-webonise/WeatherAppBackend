package com.webonise.weatherapp.service;

import java.util.List;
import com.webonise.weatherapp.model.City;

public interface CityService {
  
  /*
   * This service method will give list of city with respect to the user
   * @Param userId
   * @Return city list
   */
  List<City> getCitiesByUsername(String username,int pageNo);
  
  /*
   * This service method will save the city object in the database
   * @param userId, city object
   * @Return saved city object
   */
  City addCity(String username,City city);
}
