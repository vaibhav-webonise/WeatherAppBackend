package com.webonise.weatherapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webonise.weatherapp.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
  
   Page<City> findByUserDataId(Long userId, Pageable pageable);
   City findByCityname(String cityName);
}
