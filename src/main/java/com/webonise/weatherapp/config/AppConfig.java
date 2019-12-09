package com.webonise.weatherapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.webonise.weatherapp.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

  @Autowired
  private JwtRequestFilter jwtRequestFilter;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedHeaders("*").allowedMethods("*");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
