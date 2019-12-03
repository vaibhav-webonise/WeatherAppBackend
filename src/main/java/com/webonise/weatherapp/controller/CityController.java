package com.webonise.weatherapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webonise.weatherapp.model.City;
import com.webonise.weatherapp.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping("/{username}/{pageNo}")
  public List<City> getCitiesByUserId(@PathVariable String username, @PathVariable int pageNo) {
    return cityService.getCitiesByUsername(username, pageNo);
  }

  @PostMapping("/{username}")
  public City addCity(@PathVariable String username, @RequestBody City city) {
    return cityService.addCity(username, city);
  }
}
