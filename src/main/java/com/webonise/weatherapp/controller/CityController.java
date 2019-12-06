package com.webonise.weatherapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.webonise.weatherapp.model.City;
import com.webonise.weatherapp.model.UserData;
import com.webonise.weatherapp.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping("/{pageNo}")
  public List<City> getCities(@PathVariable int pageNo, @RequestParam String username) {
    return cityService.getCitiesByUsername(username, pageNo);
  }

  @PostMapping("/{cityname}")
  public City addCity(@PathVariable String cityname, @RequestBody UserData user) {
    return cityService.addCity(cityname, user);
  }

  @DeleteMapping("/{cityname}")
  public long removeCities(@PathVariable String cityname) {
    return cityService.removeCities(cityname);
  }
}
