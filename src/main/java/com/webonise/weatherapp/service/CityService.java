package com.webonise.weatherapp.service;

import java.util.List;
import com.webonise.weatherapp.model.City;
import com.webonise.weatherapp.model.UserData;

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
  City addCity(String cityname,UserData user);
  
  /*
   * This service method will delete the records by cityname
   * @param cityname
   * @return no of records deleted
   */
  long removeCities(String cityname);
}
